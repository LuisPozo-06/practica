package edu.idat.practica.controller;

import edu.idat.practica.model.PromedioModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PromedioController {

    @GetMapping("/promedio")
    public String formularioPromeido (Model model){
    model.addAttribute("promediomodel", new PromedioModel());
    return "promedio";
    }
@PostMapping ("/calcularpromedio")
public String calcularPromedio (@ModelAttribute ("promediomodel")PromedioModel promedio,
                                Model model) {
    Double n1 = promedio.getN1();
    Double n2 = promedio.getN2();
    Double n3 = promedio.getN3();
    Double ef = promedio.getEf();
    Double resultado = (n1 * 0.04) + (n2 * 0.12) + (n3 * 0.24) + (ef * 0.60);
    String resultadotxt = "";

    if (resultado <= 13){
        resultadotxt = "Desaprobado";

    }
    else {
        resultadotxt = "Aprobado";
    }
    model.addAttribute("resultado", "El promedio es: " + resultado + ",te encuentras"+resultadotxt);
    return "promedio";
    }

}
