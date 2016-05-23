package professor;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PainelCadastrarQuestao extends JPanel {

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
    private final JPanel paneGerenciamento;
    
    public PainelCadastrarQuestao() {
        this.setLayout(null);

        CardLayout cards = new CardLayout();
        paneGerenciamento = new JPanel();
        paneGerenciamento.setLayout(cards);
        paneGerenciamento.setPreferredSize(new Dimension(750,675));
        paneGerenciamento.setBounds(1, 1, 750, 675);
        this.add(paneGerenciamento);
        
        paneQuestaoObjetiva = new JPanel();
        paneQuestaoObjetiva.setPreferredSize(new Dimension(750, 675));
        paneQuestaoObjetiva.setBorder(BorderFactory.createLineBorder(Color.black));
        paneQuestaoObjetiva.setBounds(1, 1, 750,675);
        paneGerenciamento.add(paneQuestaoObjetiva,"0");
        painel1(paneQuestaoObjetiva);
        
        paneQuestaoDiscursiva = new JPanel();
        paneQuestaoDiscursiva.setPreferredSize(new Dimension(850,675));
        paneQuestaoDiscursiva.setBorder(BorderFactory.createLineBorder(Color.black));
        paneQuestaoDiscursiva.setBounds(1, 1, 750, 675);
        paneGerenciamento.add(paneQuestaoDiscursiva,"1");
        painel2(paneQuestaoDiscursiva);
        
        cbTipoQuestao = new JComboBox();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        cbTipoQuestao.setModel(modelo);
        modelo.addElement("Questao objetiva");
        modelo.addElement("Questao discursiva");
        cbTipoQuestao.setBounds(850,15,275,35);
        this.add(cbTipoQuestao);
        
        
        cbTipoQuestao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JComboBox cb = (JComboBox)ae.getSource();
                cb.setModel(modelo);
                if(modelo.getSelectedItem().equals("Questao objetiva")){
                    cards.show(paneQuestaoObjetiva.getParent(), "0");
                }
                if(modelo.getSelectedItem().equals("Questao discursiva")){
                    cards.show(paneQuestaoDiscursiva.getParent(), "1");
                }
            }
        });
    }
    
    private void painel1(JPanel painel){
        txID = new JTextField();
        String[] x = {"AAAAAAAAAAAAAAAA"};
        cbDisciplina = new JComboBox(x);
        txTitulo = new JTextField();
        txaEnunciado = new JTextArea(8,5);
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
        String[] x = {"AAAAAAAAAAAAAAAA"};
        cbDisciplina = new JComboBox(x);
        txTitulo = new JTextField();
        txaEnunciado = new JTextArea(8,5);
        txaEnunciado.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(txaEnunciado);
        botaoSalvar = new JButton("Salvar");
        botaoVoltar = new JButton("Voltar");
        
        painel.setLayout(new GridBagLayout());
        adicionar("ID: ", txID, painel);
        adicionar("Disciplina: ", cbDisciplina, painel);
        adicionar("Titulo: ", txTitulo, painel);
        adicionar("Enuciado: ", scrollPane, painel);
        adicionar(botaoSalvar, botaoVoltar, painel);
    }
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
}