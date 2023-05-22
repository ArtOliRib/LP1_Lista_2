package Escola;

import javax.swing.JOptionPane;
import java.util.*;


class SistemaEscola {

    private final int MAXIMOALUNOS = 10;

    //////////////////////////////////////

    public Turma turmai () {
        return (new Turma());
    }

    //////////////////////////////////////

     abstract class Pessoa {



         private String nome;
         private String email;
         private long telefone;
         private int id;

         public Pessoa () {}
         public Pessoa (int id) {
             this.id = id;
         }
         public Pessoa(int id, String nome){
             this.id = id;
             this.nome = nome;
         }
         public Pessoa (int id, String nome, String email) {
             this.id = id;
             this.nome = nome;
             this.email = email;
         }
         public Pessoa (int id, String nome, String email, long telefone) {
             this.id = id;
             this.nome = nome;
             this.email = email;
             this.telefone = telefone;
         }


         public String getNome() {
             return nome;
         }
         public String getEmail() {
             return email;
         }
         public long getTelefone() {
             return telefone;
         }

         public int getId() {
             return id;
         }

         abstract public void setNome();
         abstract public void setEmail();
         abstract public void setTelefone();

     }

     ///////////////////////////////////////////////////////////////////////////////////

     class Responsavel extends Pessoa {

         public Responsavel () {super();}
         public Responsavel (int id) {super.id = id + 99;}
         public Responsavel(int id, String nome) {super(id + 99, nome);}
         public Responsavel (int id, String nome, String email) {super (id + 99, nome, email);}
         public Responsavel (int id, String nome, String email, long telefone) {super (id + 99, nome, email, telefone);}

         public void setNome() {super.nome = JOptionPane.showInputDialog("Qual eh o nome do responsavel com ID " + super.id + "? Digite: ");}
         public void setEmail() {
             super.email = JOptionPane.showInputDialog("Qual eh o email do responsavel com ID " + super.id + "? Digite: ");
         }
         public void setTelefone() {
             int erro;
             String aux;
             long telefoneAux = 0;

             do {
                 erro = 1;
                 try {
                     aux = JOptionPane.showInputDialog("Qual eh o telefone do responsavel com ID " + super.id + "? Digite o ddd do territorio federal (2 digitos) junto com o numero de telefone (9 digitos) sem espaço e sem hifen: ");
                     if (aux.length() != 11) {
                         JOptionPane.showMessageDialog(null, "Você digitou um telefone diferente da quantidade pedida de 5 dígitos! Digite novamente!");
                         erro = 0;
                     }
                     telefoneAux = Long.parseLong(aux);

                 } catch (NumberFormatException error) {
                     erro = 0;
                     JOptionPane.showMessageDialog(null,"Você não digitou apenas número, mas também um símbolo estranho! Tente novamente!");
                 }
             } while (erro != 1);

             super.telefone = telefoneAux;
         }

     }

     ////////////////////////////////////////////////////////////////////

     class Aluno extends Pessoa {

         public Aluno () {super();}
         public Aluno (int id) {super(id);}
         public Aluno (int id, String nome) {super(id, nome);}
         public Aluno (int id, String nome, String email) {super (id, nome, email);}
         public Aluno (int id, String nome, String email, long telefone) {super (id, nome, email, telefone);}

         private ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();
         private long matricula;

         public void getResponsaveis() {

             System.out.println("Esta é a lista de responsaveis de estudante " + super.nome + ": \n");

             for (Responsavel aux: responsaveis) {

                 System.out.println("O ID do responsavel é " + aux.getId());
                 System.out.println("O nome do responsavel é " + aux.getNome());
                 System.out.println("O email do responsavel é " + aux.getEmail());
                 System.out.println("O telefone do responsavel é " + aux.getTelefone() + "\n");

             }

         }
         public long getMatricula() {
             return matricula;
         }

         public ArrayList<Responsavel> setResponsavel() {

             responsaveis.add(new Responsavel(super.id));
             String aux;

             for (int i = 0; i < responsaveis.toArray().length; i++) {

                 this.responsaveis.get(i).setNome();
                 this.responsaveis.get(i).setEmail();
                 this.responsaveis.get(i).setTelefone();

                 aux = JOptionPane.showInputDialog("Voce quer adicionar mais um responsavel? Digite 'Nao' se voce estiver satisfeito, ou digite 'Sim' se quiser adicionar mais um responsavel: ");

                 if (aux.equalsIgnoreCase("sim"))
                     responsaveis.add(new Responsavel());
             }

             return responsaveis;
         }
         public void setMatricula() {

             int erro;
             String aux;
             long matriculaAux = 0;

             do {
                 erro = 1;
                 try {
                     aux = JOptionPane.showInputDialog(null, "Digite 5 dígitos numéricos para representar a matrícula do aluno: ");
                     if (aux.length() != 5) {
                         JOptionPane.showMessageDialog(null, "Você digitou uma matrícula diferente de 5 dígitos! Digite novamente!");
                         erro = 0;
                     }
                     matriculaAux = Long.parseLong(aux);

                 } catch (NumberFormatException error) {
                     erro = 0;
                     JOptionPane.showMessageDialog(null,"Você não digitou apenas número, mas também um símbolo estranho! Tente novamente!");
                 }
             } while (erro != 1);

             this.matricula = matriculaAux;
         }

         public void setNome() {super.nome = JOptionPane.showInputDialog("Qual eh o nome do aluno com ID " + super.id + "? Digite: ");}
         public void setEmail() {
             super.email = JOptionPane.showInputDialog("Qual eh o email do aluno com ID " + super.id + "? Digite: ");
         }
         public void setTelefone() {

             int erro = 1;
             String aux;
             long telefoneAux = 0;

             do {
                 erro = 1;
                 try {
                     aux = JOptionPane.showInputDialog("Qual eh o telefone do aluno com ID " + super.id + "? Digite o ddd do territorio federal (2 digitos) junto com o numero de telefone (9 digitos) sem espaço e sem hifen: ");
                     if (aux.length() != 11) {
                         JOptionPane.showMessageDialog(null, "Você digitou um telefone diferente da quantidade pedida de 5 dígitos! Digite novamente!");
                         erro = 0;
                     }
                    telefoneAux = Long.parseLong(aux);

                 } catch (NumberFormatException error) {
                     erro = 0;
                     JOptionPane.showMessageDialog(null,"Você não digitou apenas número, mas também um símbolo estranho! Tente novamente!");
                 }
             } while (erro != 1);

             super.telefone = telefoneAux;
         }



     }

     ////////////////////////////////////////////////////////////////////////////////////////////////

      class Turma {

         private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
         private ArrayList<Responsavel> responsaveis = new ArrayList<Responsavel>();

         public Turma () {}

         public void addAlunos () {

             Aluno aux;

             for (int i = 0; i < MAXIMOALUNOS; i++) {

                 ArrayList<Responsavel> responsaveisUnicos = new ArrayList<Responsavel>();

                 aux = new Aluno(i + 1);
                 aux.setNome();
                 aux.setEmail();
                 aux.setTelefone();
                 aux.setMatricula();
                 responsaveisUnicos = aux.setResponsavel();

                 for (Responsavel responsa: responsaveisUnicos)
                     responsaveis.add(responsa);

                 alunos.add(aux);

             }
         }

         public void getAlunos(String mostrarResponsa) {

             for (Aluno aux: alunos) {

                 System.out.println("O ID do aluno é " + aux.getId());
                 System.out.println("O nome do aluno é " + aux.getNome());
                 System.out.println("O email do aluno é " + aux.getEmail());
                 System.out.println("O telefone do aluno é " + aux.getTelefone());
                 System.out.println("A matricula do aluno é " + aux.getMatricula() + "\n");

                 if (mostrarResponsa.equalsIgnoreCase("sim"))
                    aux.getResponsaveis();

             }

         }

         public void getResponsaveis () {

             System.out.println("Esta é a lista de responsaveis: \n");

             for (Responsavel aux: responsaveis) {

                 System.out.println("O ID do responsavel é " + aux.getId());
                 System.out.println("O nome do responsavel é " + aux.getNome());
                 System.out.println("O email do responsavel é " + aux.getEmail());
                 System.out.println("O telefone do responsavel é " + aux.getTelefone() + "\n");

             }

         }

         public void indiceNome () {

             char s;
             int erro;

             do {

                 erro = 1;

                 s = JOptionPane.showInputDialog("Pesquisar pelo indice (digite 'i') ou o nome (digite 'n'): ").charAt(0);

                 if (s == 'i') {

                    int id = Integer.parseInt(JOptionPane.showInputDialog("Qual eh o indice que tem o estudante? Digite: "));

                     System.out.println("O ID do aluno é " + alunos.get(id - 1).getId());
                     System.out.println("O nome do aluno é " + alunos.get(id - 1).getNome());
                     System.out.println("O email do aluno é " + alunos.get(id - 1).getEmail());
                     System.out.println("O telefone do aluno é " + alunos.get(id - 1).getTelefone());
                     System.out.println("A matricula do aluno é \n" + alunos.get(id - 1).getMatricula());
                     alunos.get(id - 1).getResponsaveis();

                 } else if (s == 'n') {

                     String nome = JOptionPane.showInputDialog("Qual eh o nome que tem o estudante? Digite: ");

                     for (Aluno alunoEscolhido: alunos)
                         if (alunoEscolhido.getNome().equalsIgnoreCase(nome)) {
                             System.out.println("O ID do aluno é " + alunoEscolhido.getId());
                             System.out.println("O nome do aluno é " + alunoEscolhido.getNome());
                             System.out.println("O email do aluno é " + alunoEscolhido.getEmail());
                             System.out.println("O telefone do aluno é " + alunoEscolhido.getTelefone());
                             System.out.println("A matricula do aluno é " + alunoEscolhido.getMatricula() + "\n");
                             alunoEscolhido.getResponsaveis();
                         }

                 } else {
                     erro = 0;
                     JOptionPane.showMessageDialog(null, "Erro! Nao foi digitado uma das opçoes! Tente novamente");
                 }
             } while (erro != 1);


         }

         public int menu () {

             int escolha;

             System.out.println("\t=-=-=-=-=-=-=-=-=    MENU    =-=-=-=-=-=-=-=-=\n");
             System.out.println("\t Decida agora o que voce quer imprimir. Digite o numero correspondente a opçao: ");
             System.out.println("\t 1 - Imprimir apenas a lista de alunos ");
             System.out.println("\t 2 - Imprimir apenas a lista de responsaveis ");
             System.out.println("\t 3 - Imprimir a lista de alunos com seus respectivos responsaveis");
             System.out.println("\t 4 - Imprimir um aluno pesquisando seu nome ou seu indice");
             System.out.println("\t 5 - Terminar o programa!");

             escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de acordo com as opçoes do menu que apareceu no terminal: "));

             if (escolha == 1)
                 getAlunos("nao");
             else if (escolha == 2)
                 getResponsaveis();
             else if (escolha == 3)
                 getAlunos("sim");
             else if (escolha == 4)
                 indiceNome();

             if (escolha == 5)
                 return 0;
             else
                 return 1;
         }



     }

}
