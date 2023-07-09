package main;

import model.Cliente;
import model.Endereco;
import processadorxml.XMLProcessor;

public class MainClass {
    public static void main(String[] args) {
        Cliente c = new Cliente();
        c.setId(12345);
        c.setNome("João da Silva");
        c.setTelefone("987654321");
        c.setEmail("joao@email.com");

        Endereco e = new Endereco();
        e.setTipo("Rua");
        e.setLogradouro("José da Silva");
        e.setNumero(44);
        e.setBairro("Liberdade");
        e.setCidade("Sao Paulo");
        e.setComplemento("AP A100");
        e.setUf("SP");
        e.setCep("12345-678");

        c.setEndereco(e);


        try {
            System.out.println(XMLProcessor.generateXML(c));
        }
        catch(Exception ex){
            System.out.println("Deu ruim!!!");
            ex.printStackTrace();
        }
    }
}
