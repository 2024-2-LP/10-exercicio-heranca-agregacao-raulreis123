package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

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

    public Integer qtdDesenvolvedoresMobile(){
        int cont = 0;
        for (Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                cont++;
            }
        }

        return cont;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devs = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores){
            if(dev.calcularSalario() >= salario){
                devs.add(dev);
            }
        }

        return devs;
    }

    public Desenvolvedor buscarMenorSalario(){
        if(desenvolvedores.isEmpty()){
            return null;
        }

        Desenvolvedor dev = desenvolvedores.get(0);

        for(Desenvolvedor devDaVez : desenvolvedores){
            if(devDaVez.calcularSalario() < dev.calcularSalario()){
                dev = devDaVez;
            }
        }

        return dev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia)){
                    devs.add(dev);
                }
                if(((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)){
                    devs.add(dev);
                }
            }

            if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getBackend().equals(tecnologia)){
                    devs.add(dev);
                }
                if(((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)){
                    devs.add(dev);
                }
                if(((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia)){
                    devs.add(dev);
                }
            }
        }

        return devs;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salario = 0.0;

        for (Desenvolvedor dev : desenvolvedores){
            if(dev instanceof DesenvolvedorMobile){
                if(((DesenvolvedorMobile) dev).getPlataforma().equals(tecnologia)){
                    salario += dev.calcularSalario();
                }
                if(((DesenvolvedorMobile) dev).getLinguagem().equals(tecnologia)){
                    salario += dev.calcularSalario();
                }
            }

            if(dev instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) dev).getBackend().equals(tecnologia)){
                    salario += dev.calcularSalario();
                }
                if(((DesenvolvedorWeb) dev).getFrontend().equals(tecnologia)){
                    salario += dev.calcularSalario();
                }
                if(((DesenvolvedorWeb) dev).getSgbd().equals(tecnologia)){
                    salario += dev.calcularSalario();
                }
            }
        }

        return salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
