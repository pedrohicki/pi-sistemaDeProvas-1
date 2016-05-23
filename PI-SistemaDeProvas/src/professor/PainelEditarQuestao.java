
package professor;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelEditarQuestao extends JPanel{
    
    private JComboBox cbDisciplina;
    private JComboBox cbTipoQuestao;

    private JTextField txID;
    private JTextField txTitulo;
    
    private JTextArea txaEnunciado;
    private JTextArea txaResposta0;
    private JTextArea txaResposta1;
    private JTextArea txaResposta2;
    private JTextArea txaResposta3;
    private JTextArea txaResposta4;
    
    private JButton botaoSalvar;
    JButton botaoVoltar;
    
    private JPanel paneQuestaoObjetiva;
    private JPanel paneQuestaoDiscursiva;
    
    public PainelEditarQuestao(){
        
        //**************************************************//
        //Adicionar um IF para mostrar tela dependendo do tipo da questão.
        //**************************************************//
        painel1(this);
    }
    
    private void painel1(JPanel painel){
        txID = new JTextField();
        txID.setEditable(false);
        String[] x = {"AAAAAAAAAAAAAAAA"};
        cbDisciplina = new JComboBox(x);
        txTitulo = new JTextField();
        txaEnunciado = new JTextArea(7,5);
        txaEnunciado.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txaEnunciado);
        txaResposta0 = new JTextArea(4,5);
        txaResposta0.setLineWrap(true);
        txaResposta1 = new JTextArea(4,5);
        txaResposta1.setLineWrap(true);
        txaResposta2 = new JTextArea(4,5);
        txaResposta2.setLineWrap(true);
        txaResposta3 = new JTextArea(4,5);
        txaResposta3.setLineWrap(true);
        txaResposta4 = new JTextArea(4,5);
        txaResposta4.setLineWrap(true);
        JScrollPane scrollPane0 = new JScrollPane(txaResposta0);
        JScrollPane scrollPane1 = new JScrollPane(txaResposta1);
        JScrollPane scrollPane2 = new JScrollPane(txaResposta2);
        JScrollPane scrollPane3 = new JScrollPane(txaResposta3);
        JScrollPane scrollPane4 = new JScrollPane(txaResposta4);
        botaoSalvar = new JButton("Salvar");
        botaoVoltar = new JButton("Voltar");
        
        painel.setLayout(new GridBagLayout());
        adicionar("Editar questão objetiva:",painel);
        adicionar("ID: ", txID, painel);
        adicionar("Disciplina: ", cbDisciplina, painel);
        adicionar("Titulo: ", txTitulo, painel);
        adicionar("Enuciado: ", scrollPane, painel);
        adicionar("1- ",scrollPane0, painel);
        adicionar("2- ",scrollPane1, painel);
        adicionar("3- ",scrollPane2, painel);
        adicionar("4- ",scrollPane3, painel);
        adicionar("5- ",scrollPane4, painel);
        adicionar(botaoSalvar, botaoVoltar, painel);
    }
    
    private void painel2(JPanel painel){
        txID = new JTextField();
        txID.setEditable(false);
        String[] x = {"AAAAAAAAAAAAAAAA"};
        cbDisciplina = new JComboBox(x);
        txTitulo = new JTextField();
        txaEnunciado = new JTextArea(8,5);
        txaEnunciado.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txaEnunciado);
        botaoSalvar = new JButton("Salvar");
        botaoVoltar = new JButton("Voltar");
        
        painel.setLayout(new GridBagLayout());
        adicionar("Editar questão discursiva:",painel);
        adicionar("ID: ", txID, painel);
        adicionar("Disciplina: ", cbDisciplina, painel);
        adicionar("Titulo: ", txTitulo, painel);
        adicionar("Enuciado: ", scrollPane, painel);
        adicionar(botaoSalvar, botaoVoltar, painel);
    }
    /*
    *@Adiciona um JLabel e um JComponent no JPanel horizontalmente.
    */
    public void adicionar(String label, JComponent componente, JPanel painel) {  
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.NONE;  
        cons.anchor = GridBagConstraints.NORTHWEST;  
        cons.insets = new Insets(4,4,4,4);  
  
        cons.weightx = 0;  
        cons.gridwidth = 1;  
        painel.add(new JLabel(label), cons);  
          
        cons.fill = GridBagConstraints.BOTH;  
        cons.weightx = 1;  
        cons.gridwidth = GridBagConstraints.REMAINDER;  
        painel.add(componente, cons);  
    }
    /*
    *@Adiciona o painel de botões no centro no JPanel.
    */
    public void adicionar(JButton botao1,JButton botao2, JPanel painel){
        GridBagConstraints cons = new GridBagConstraints();  
        cons.fill = GridBagConstraints.BOTH;
        cons.insets = new Insets(4,4,4,4);
        cons.anchor = GridBagConstraints.CENTER;
        cons.gridwidth = 2;
        JPanel p = new JPanel();
        p.add(botao1);
        p.add(botao2);
        painel.add(p,cons);
     }
    /*
    *@Adiciona um JLabel centralizado no JPanel
    */
    public void adicionar(String label, JPanel painel){
        GridBagConstraints cons = new GridBagConstraints(); 
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel jlabel = new JLabel(label);
        container.add(jlabel);
        cons.fill = GridBagConstraints.BOTH;
        cons.anchor = GridBagConstraints.CENTER;
        cons.insets = new Insets(4,4,4,4);
        cons.weightx = 0;
        cons.gridwidth = GridBagConstraints.REMAINDER;
        painel.add(container,cons);
    }
}
