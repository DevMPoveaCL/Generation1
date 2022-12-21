package com.generation1.generation1.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.generation1.generation1.model.License;
import com.generation1.generation1.repository.LicenseRepository;

@Service
@Transactional
public class LicenseService {
    private LicenseRepository licenseRepository;

    public LicenseService(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }

    public void saveLicense(License license) {
        licenseRepository.save(license);
    }

    public void updateLicense(License license) {
        licenseRepository.save(license);
    }

    public List<License> findAll() {
        return licenseRepository.findAll();
    }

    public void eliminarLicencia(Integer id) {
        licenseRepository.deleteById(id);
    }

    // Tipo de Licencia
    public List<License> buscarPorLicencia(String clase) {
        return licenseRepository.findAllClase(clase);
    }

    // Estado
    public List<License> buscarPorEstado(String estado) {
        return licenseRepository.findAllEstado(estado);
    }

    // Estado y clase
    public List<License> buscarPorEstadoClase(String estado, String clase) {
        return licenseRepository.findAllEstadoClase(estado, clase);
    }

    // Fecha de vencimiento & usuario
    /*
     * public List <License> buscarFdeVdelUsuario(){
     * return licenseRepository.buscaFechaVencimientoDelUsuario();
     * }
     */
}
