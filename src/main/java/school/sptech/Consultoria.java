package school.sptech;

import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public Boolean contratar(Desenvolvedor desenvolvedor){
        if(vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }

        return false;
    }

    public Double getTotalSalarios(){
        Double salario = 0.0;

        for (Desenvolvedor dev : desenvolvedores){
            salario += dev.calcularSalario();
        }

        return salario;
    }
}
