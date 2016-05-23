package professor;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public final class FrameProfessor extends JFrame{
    private JMenuBar barraMenu;
    
    private JMenu menuInicial;
    private JMenuItem menuInicialPrincipal;
    
    private JMenu menuQuestao;
    private JMenuItem menuQuestaoListar;
    private JMenuItem menuQuestaoCadastrar;
    
    private JMenu menuProva;
    private JMenuItem menuProvaCriar;
    private JMenuItem menuProvaEditar;
    private JMenuItem menuProvaExcluir;
    
    private JMenu menuAluno;
    private JMenuItem menuAlunoListar;
    private JMenuItem menuAlunoConsultarRecursos;
    
    private JMenu menuGeral;
    private JMenuItem menuGeralDeslogar;
    private JMenuItem menuGeralSair;
    /////////////////////////////////////////////////////////
    public CardLayout cards;
    private JPanel painelBranco;
    private PainelCadastrarQuestao painelCadastrarQuestao;
    private PainelListarQuestao painelListarQuestao;
    private PainelEditarQuestao painelEditarQuestao;
    
    public FrameProfessor(){
        navegacao();
        setSize(800,600);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void navegacao(){
        painelBranco = new JPanel();
        painelCadastrarQuestao = new PainelCadastrarQuestao();
        painelListarQuestao = new PainelListarQuestao();
        painelEditarQuestao = new PainelEditarQuestao();
        cards = new CardLayout();
        this.setLayout(cards);
        this.add(painelBranco,"0");
        this.add(painelCadastrarQuestao,"1");
        this.add(painelListarQuestao,"2");
        this.add(painelEditarQuestao,"3");
        //****************************************//
        //BOTÕES//
        painelListarQuestao.btNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelCadastrarQuestao.getParent(),"1");
            }
        });
        painelListarQuestao.btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelEditarQuestao.getParent(),"3");
            }
        });
        painelListarQuestao.btVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelBranco.getParent(),"0");
            }
        });
        painelEditarQuestao.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelBranco.getParent(),"0");
            }
        });
        painelCadastrarQuestao.botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelBranco.getParent(),"0");
            }
        });
        //****************************************//
        //ITENS DO MENU//
        barraMenu = new JMenuBar();
        
        menuInicial = new JMenu("Principal");
        menuInicialPrincipal = new JMenuItem("Página inicial");
        menuInicialPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelBranco.getParent(),"0");
            }
        });
        menuInicial.add(menuInicialPrincipal);
        
        
        menuQuestao = new JMenu("Questões");
        menuQuestaoListar = new JMenuItem("Listar questões");
        menuQuestaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelListarQuestao.getParent(),"2");
            }
        });
        
        menuQuestaoCadastrar = new JMenuItem("Cadastrar questão");
        menuQuestaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cards.show(painelCadastrarQuestao.getParent(),"1");
            }
        });
        
        menuQuestao.add(menuQuestaoListar);
        menuQuestao.add(menuQuestaoCadastrar);
        
        menuProva = new JMenu("Provas");
        menuProvaCriar = new JMenuItem("Criar prova");
        menuProvaEditar = new JMenuItem("Editar prova");
        menuProvaExcluir = new JMenuItem("Excluir prova");
        menuProva.add(menuProvaCriar);
        menuProva.add(menuProvaEditar);
        menuProva.add(menuProvaExcluir);
        
        menuAluno = new JMenu("Alunos");
        menuAlunoListar = new JMenuItem("Listar alunos");
        menuAlunoConsultarRecursos = new JMenuItem("Consultar recursos");
        menuAluno.add(menuAlunoListar);
        menuAluno.add(menuAlunoConsultarRecursos);
        
        menuGeral = new JMenu("Geral");
        menuGeralDeslogar = new JMenuItem("Trocar de usuário");
        menuGeralSair = new JMenuItem("Sair");
        menuGeralSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        menuGeral.add(menuGeralDeslogar);
        menuGeral.add(menuGeralSair);
        
        barraMenu.add(menuInicial);
        barraMenu.add(menuQuestao);
        barraMenu.add(menuProva);
        barraMenu.add(menuAluno);
        barraMenu.add(menuGeral);
        
        setJMenuBar(barraMenu);
    }
}
