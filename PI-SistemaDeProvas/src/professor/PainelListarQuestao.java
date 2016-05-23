
package professor;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PainelListarQuestao extends JPanel{
    
    private JLabel lbTitulo;
    private JTable tabela;
    private DefaultTableModel modelo;
    private JScrollPane painelDeRolagem;
    JButton btNovo;
    JButton btEditar;
    private JButton btExcluir;
    JButton btVoltar;
    private JPanel paneBotoes;
    
    JPanel painelListarQuestao;
    PainelCadastrarQuestao painelCadastrarQuestao;
    PainelEditarQuestao painelEditarQuestao;
    
    
    public PainelListarQuestao(){
        painelListarQuestao = new JPanel();
        montaPane(this);
        
    }
    
    public void montaPane(JPanel painel){
        GridBagConstraints cons = new GridBagConstraints();
        painel.setLayout(new GridBagLayout());
        lbTitulo = new JLabel("Questões");
        lbTitulo.setFont(new Font("Arial", Font.BOLD,40));
        Object[][] dados = {{"0001","Questao de redes","Rede de computadores"},
            {"0002","Questao de programação","Programação"}};
        String[] colunas = {"ID","Titulo","Disciplina"};
        modelo = new DefaultTableModel(dados,colunas);
        tabela = new JTable();
        tabela.setModel(modelo);
        modelo.isCellEditable(1,1);
        painelDeRolagem = new JScrollPane(tabela);
        btNovo = new JButton("Novo");
        btEditar = new JButton("Editar");
        btExcluir = new JButton("Excluir");
        btVoltar = new JButton("voltar");
        paneBotoes = new JPanel();
        paneBotoes.add(btNovo);
        paneBotoes.add(btEditar);
        paneBotoes.add(btExcluir);
        paneBotoes.add(btVoltar);
        
        painel.add(lbTitulo,cons);
        
        cons.gridy = 2;
        painel.add(paneBotoes,cons);
        
        cons.gridy = 1;
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = .8;
        painel.add(painelDeRolagem,cons);
    }
}
