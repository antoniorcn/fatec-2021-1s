package edu.curso.medicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServicos {

//    @Autowired
    ConsultaRepository consultaRepository;

//    @Autowired
    MedicoRepository medicoRepository;

    ConsultaServicos(ConsultaRepository consultaRepository, MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Page<Consulta> listarConsultasPaginacao(Pageable page) {
        return consultaRepository.findAll(page);
    }


    public void adicionarConsulta(Consulta consulta) {
        Medico m1 = medicoRepository.findByCrm("000004");
        // Medico m2 = medicoRepository.findByCrm("000001");
        consulta.getMedicos().add(m1);
        // consulta.getMedicos().add(m2);
        consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultasPorPaciente(String nomePaciente) {
        return consultaRepository.findByNomePaciente(nomePaciente);
    }
}
