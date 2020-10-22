package com.xocop.mediaappbackend.service.impl;

import com.xocop.mediaappbackend.dto.ConsultaExamenDTO;
import com.xocop.mediaappbackend.dto.ConsultaResumenDTO;
import com.xocop.mediaappbackend.dto.FiltroConsultaDTO;
import com.xocop.mediaappbackend.model.Consulta;
import com.xocop.mediaappbackend.model.ConsultaExamen;
import com.xocop.mediaappbackend.repo.IConsulta;
import com.xocop.mediaappbackend.repo.IConsultaExamen;
import com.xocop.mediaappbackend.service.IConsultaService;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private IConsulta service;

    @Autowired
    private IConsultaExamen service2;

    @Override
    public Consulta registrar(Consulta obj) {
        obj.getDetalleConsulta().forEach(detalleConsulta -> {
            //como se esta creando, entoces el objeto Consulta del DetalleConsulta es el que viene ingresandose
            detalleConsulta.setConsulta(obj);
        });
        return  service.save(obj);
    }

    @Override
    public Consulta modificar(Consulta obj) {
        return service.save(obj);
    }

    @Override
    public List<Consulta> listar() {
        return service.findAll();
    }

    @Override
    public Consulta listarPorId(Integer id) {
        Optional<Consulta> op=service.findById(id);
        return op.isPresent()?op.get():new Consulta();
    }

    @Override
    public boolean eliminar(Integer id) {
        service.deleteById(id);
        return true;
    }

    @Override
    public Consulta registrarDTO(ConsultaExamenDTO dto) {
        dto.getConsulta().getDetalleConsulta().forEach(det->{
            det.setConsulta(dto.getConsulta());
        });
        service.save(dto.getConsulta());
        dto.getListExamen().forEach(examen -> {
            service2.registrar(dto.getConsulta().getIdConsulta(),examen.getIdExamen());
        });
        return dto.getConsulta();
    }

    @Override
    public List<Consulta> buscarDni(FiltroConsultaDTO filtro) {
        return service.buscarDni(filtro.getDni());
    }

    @Override
    public List<Consulta> buscarNombres(FiltroConsultaDTO filtro) {
        return service.buscarNombres(filtro.getNombreCompleto().toLowerCase());
    }
    @Override
    public List<Consulta> buscarFecha(FiltroConsultaDTO filtro) {
        LocalDateTime fechasgte=filtro.getFechaConsulta().plusDays(1);
        return service.buscarFecha(filtro.getFechaConsulta(), fechasgte);
    }

    @Override
    public List<ConsultaExamen> listarExamenesPorConsulta(Integer idConsulta) {
        return  service2.listarExamenesPorConsulta(idConsulta);
    }

    @Override
    public List<ConsultaResumenDTO> listarResumen() {
        List<ConsultaResumenDTO> lista=new ArrayList<>();
        service.listarResumen().forEach(x->{
            ConsultaResumenDTO obj=new ConsultaResumenDTO();
            obj.setCantidad(Integer.parseInt(String.valueOf(x[0])));
            obj.setFecha(String.valueOf(x[1]));
            lista.add(obj);
        });
        return  lista;
    }

    @Override
    public byte[] generarReporte() {
        byte[] data=null;
        //HashMap<String, String> params = new HashMap<String, String>();
        //params.put("txt_empresa", "MitoCode Network");
        try {
            File file = new ClassPathResource("/reports/consultas.jasper").getFile();
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), null, new JRBeanCollectionDataSource(this.listarResumen()));
            data = JasperExportManager.exportReportToPdf(print);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}
