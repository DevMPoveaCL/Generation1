package com.generation1.generation1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation1.generation1.model.License;
import com.generation1.generation1.service.LicenseService;

@CrossOrigin("*")
@RestController
public class LicenseController {
    private LicenseService licenseService;

    public LicenseController(@Autowired LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @PostMapping("/License/save")
    public void guardarLicencia(@RequestBody License license) {
        licenseService.saveLicense(license);
    }

    @PutMapping("/License/update")
    public void actualizarLicencia(@RequestBody License license) {
        licenseService.updateLicense(license);
    }

    @GetMapping("/License/findAll")
    public List<License> todasLasLicencias() {
        return licenseService.findAll();
    }

    @DeleteMapping("/License/eliminarLicencia/{id}")
    public void deleteLicencia(@PathVariable Integer id) {
        licenseService.eliminarLicencia(id);
    }

    // Tipo de Licencia
    @GetMapping("/License/buscarPorClase/{clase}")
    public List<License> buscarPorClase(@PathVariable String clase) {
        return licenseService.buscarPorLicencia(clase);
    }

    // Estado
    @GetMapping("/License/buscarPorEstado/{estado}")
    public List<License> buscarPorEstadoLicencia(@PathVariable String estado) {
        return licenseService.buscarPorEstado(estado);
    }
    // Estado y clase

    // Fecha de vencimiento & usuario

}
