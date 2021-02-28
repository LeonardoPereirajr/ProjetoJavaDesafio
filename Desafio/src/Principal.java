
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.PrintWriter;


/**
 *
 * @author Leo Pereira
 */
public class Principal extends javax.swing.JFrame {

    ArrayList<Sala> ListaSalas;
    ArrayList<Alunos> ListaAlunos;
    String modoSal;
    String modoAluno;
    
   /*
    Metodo tabela de salas
    */ 
    
    public void LoadTableSalas(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Codigo", "Nome"}, 0);
           
        for (int i = 0; i<ListaSalas.size();i++){
            Object linha[] = new Object[]{ListaSalas.get(i).getCodigo(),
                                        ListaSalas.get(i).getNome()};
            modelo.addRow(linha);
            
            
        }
        tbl_salas_sal.setModel(modelo);
        tbl_salas_sal.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_salas_sal.getColumnModel().getColumn(1).setPreferredWidth(200);
        
        LoadCBSal();
    }
    public void LoadTableAluno(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Matricula", "Nome","Sala"}, 0);
           
        for (int i = 0; i<ListaAlunos.size();i++){
            Object linha[] = new Object[]{ListaAlunos.get(i).getMatricula(),
                                        ListaAlunos.get(i).getNome(),
                                        ListaAlunos.get(i).getSal().getNome()};
            modelo.addRow(linha);
        }
        
        tbl_aluno_alunos.setModel(modelo);
        tbl_aluno_alunos.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_aluno_alunos.getColumnModel().getColumn(1).setPreferredWidth(150);
        tbl_aluno_alunos.getColumnModel().getColumn(2).setPreferredWidth(150);
      }
    
    /*
    Metodo atualizar Salas
    */
    
    public void LoadCBSal(){
        cb_alunos_salas.removeAllItems();
        cb_alunos_salas.addItem("Selecione");
        for (int i = 0; i<ListaSalas.size();i++){
            cb_alunos_salas.addItem(ListaSalas.get(i).getNome());
           
        }
        
    }
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaSalas = new ArrayList();
        ListaAlunos = new ArrayList();
        modoSal = "Navegar";
        modoAluno = "Navegar";
        ManipulaInterfaceSal();
        ManipulaInterfaceAluno();
      
    }
    
    /*
    Metodo para facilitar desligar botoes ao manipular salas
    */
    public void ManipulaInterfaceSal(){
        switch(modoSal){
            case "Navegar":
                btn_sala_salvar.setEnabled(false);
                btn_sala_cancelar.setEnabled(false);
                c_sal_codigo.setEditable(false);
                cb_sal_nome.setEditable(false);
                btn_sala_novo.setEnabled(true);
                btn_sala_editar.setEnabled(false);
                btn_sala_excluir.setEnabled(false);
                break;
            
            case "Novo":
                btn_sala_salvar.setEnabled(true);
                btn_sala_cancelar.setEnabled(true);
                c_sal_codigo.setEditable(true);
                cb_sal_nome.setEditable(true);
                btn_sala_novo.setEnabled(false);
                btn_sala_editar.setEnabled(false);
                btn_sala_excluir.setEnabled(false);
                break;
                
            case "Editar": 
                btn_sala_salvar.setEnabled(true);
                btn_sala_cancelar.setEnabled(true);
                c_sal_codigo.setEditable(true);
                cb_sal_nome.setEditable(true);
                btn_sala_novo.setEnabled(true);
                btn_sala_editar.setEnabled(false);
                btn_sala_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                btn_sala_salvar.setEnabled(false);
                btn_sala_cancelar.setEnabled(false);
                c_sal_codigo.setEditable(false);
                cb_sal_nome.setEditable(false);
                btn_sala_novo.setEnabled(true);
                btn_sala_editar.setEnabled(false);
                btn_sala_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                btn_sala_salvar.setEnabled(false);
                btn_sala_cancelar.setEnabled(false);
                c_sal_codigo.setEditable(false);
                cb_sal_nome.setEditable(false);
                btn_sala_novo.setEnabled(true);
                btn_sala_editar.setEnabled(true);
                btn_sala_excluir.setEnabled(true);
                break;
                
            default: System.out.println("Modo Invalido");
                
        }
        
    }
  /*
    Metodo para facilitar desligar botoes ao manipular cadastro de alunos
    */
    public void ManipulaInterfaceAluno(){
        switch(modoAluno){
            case "Navegar":
                btn_aluno_salvar.setEnabled(false);
                btn_aluno_cancelar.setEnabled(false);
                c_aluno_mat.setEditable(false);
                c_aluno_nome.setEditable(false);
                btn_aluno_novo.setEnabled(true);
                btn_aluno_editar.setEnabled(false);
                btn_aluno_excluir.setEnabled(false);
                cb_alunos_salas.setEnabled(false);
                break;
            
            case "Novo":
                btn_aluno_salvar.setEnabled(true);
                btn_aluno_cancelar.setEnabled(true);
                c_aluno_mat.setEditable(true);
                c_aluno_nome.setEditable(true);
                cb_alunos_salas.setEnabled(true);
                cb_alunos_salas.setEnabled(true);
                btn_aluno_novo.setEnabled(false);
                btn_aluno_editar.setEnabled(false);
                btn_aluno_excluir.setEnabled(false);
                break;
                
            case "Editar": 
                btn_aluno_salvar.setEnabled(true);
                btn_aluno_cancelar.setEnabled(true);
                c_aluno_mat.setEditable(true);
                c_aluno_nome.setEditable(true);
                cb_alunos_salas.setEnabled(true);
                btn_aluno_novo.setEnabled(true);
                btn_aluno_editar.setEnabled(false);
                btn_aluno_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                btn_aluno_salvar.setEnabled(false);
                btn_aluno_cancelar.setEnabled(false);
                c_aluno_mat.setEditable(false);
                c_aluno_nome.setEditable(false);
                cb_alunos_salas.setEnabled(false);
                btn_aluno_novo.setEnabled(true);
                btn_aluno_editar.setEnabled(false);
                btn_aluno_excluir.setEnabled(false);
                break;
                
            case "Selecao":
                btn_aluno_salvar.setEnabled(false);
                btn_aluno_cancelar.setEnabled(false);
                c_aluno_mat.setEditable(false);
                c_aluno_nome.setEditable(false);
                cb_alunos_salas.setEnabled(false);
                btn_aluno_novo.setEnabled(true);
                btn_aluno_editar.setEnabled(true);
                btn_aluno_excluir.setEnabled(true);
                break;
                
            default: System.out.println("Modo Invalido");
                
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_salas_sal = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_sala_salvar = new javax.swing.JButton();
        btn_sala_cancelar = new javax.swing.JButton();
        c_sal_codigo = new javax.swing.JTextField();
        cb_sal_nome = new javax.swing.JTextField();
        btn_sala_novo = new javax.swing.JButton();
        btn_sala_editar = new javax.swing.JButton();
        btn_sala_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_aluno_alunos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_aluno_salvar = new javax.swing.JButton();
        btn_aluno_cancelar = new javax.swing.JButton();
        c_aluno_mat = new javax.swing.JTextField();
        c_aluno_nome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cb_alunos_salas = new javax.swing.JComboBox<>();
        btn_aluno_novo = new javax.swing.JButton();
        btn_aluno_editar = new javax.swing.JButton();
        btn_aluno_excluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_salas_sal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_salas_sal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salas_salMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_salas_sal);
        if (tbl_salas_sal.getColumnModel().getColumnCount() > 0) {
            tbl_salas_sal.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_salas_sal.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Salas"));

        jLabel1.setText("Codigo:");

        jLabel2.setText("Nome: ");

        btn_sala_salvar.setText("SALVAR");
        btn_sala_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sala_salvarActionPerformed(evt);
            }
        });

        btn_sala_cancelar.setText("CANCELAR");
        btn_sala_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sala_cancelarActionPerformed(evt);
            }
        });

        c_sal_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_sal_codigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_sal_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_sala_salvar)
                                .addGap(26, 26, 26)
                                .addComponent(btn_sala_cancelar))
                            .addComponent(cb_sal_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_sal_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_sal_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sala_salvar)
                    .addComponent(btn_sala_cancelar)))
        );

        btn_sala_novo.setText("Novo");
        btn_sala_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sala_novoActionPerformed(evt);
            }
        });

        btn_sala_editar.setText("Editar");
        btn_sala_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sala_editarActionPerformed(evt);
            }
        });

        btn_sala_excluir.setText("Excluir");
        btn_sala_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sala_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_sala_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_sala_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sala_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_sala_novo)
                    .addComponent(btn_sala_editar)
                    .addComponent(btn_sala_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jTabbedPane1.addTab("Salas", jPanel1);

        tbl_aluno_alunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome", "Sala Estudo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_aluno_alunos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_aluno_alunosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_aluno_alunos);
        if (tbl_aluno_alunos.getColumnModel().getColumnCount() > 0) {
            tbl_aluno_alunos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tbl_aluno_alunos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tbl_aluno_alunos.getColumnModel().getColumn(2).setResizable(false);
            tbl_aluno_alunos.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Aluno"));

        jLabel3.setText("Matricula:");

        jLabel4.setText("Nome: ");

        btn_aluno_salvar.setText("SALVAR");
        btn_aluno_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aluno_salvarActionPerformed(evt);
            }
        });

        btn_aluno_cancelar.setText("CANCELAR");
        btn_aluno_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aluno_cancelarActionPerformed(evt);
            }
        });

        c_aluno_mat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_aluno_matActionPerformed(evt);
            }
        });

        jLabel5.setText("Salas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(c_aluno_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c_aluno_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_aluno_salvar)
                                .addGap(26, 26, 26)
                                .addComponent(btn_aluno_cancelar))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_alunos_salas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_aluno_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_aluno_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_alunos_salas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aluno_salvar)
                    .addComponent(btn_aluno_cancelar)))
        );

        btn_aluno_novo.setText("Novo");
        btn_aluno_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aluno_novoActionPerformed(evt);
            }
        });

        btn_aluno_editar.setText("Editar");
        btn_aluno_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aluno_editarActionPerformed(evt);
            }
        });

        btn_aluno_excluir.setText("Excluir");
        btn_aluno_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_aluno_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_aluno_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(btn_aluno_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_aluno_excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_aluno_novo)
                    .addComponent(btn_aluno_editar)
                    .addComponent(btn_aluno_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Alunos", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
    Manutenção de sala
    */
    
    private void btn_sala_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sala_novoActionPerformed
        c_sal_codigo.setText("");
        cb_sal_nome.setText("");
        modoSal = "Novo";
        ManipulaInterfaceSal();
    }//GEN-LAST:event_btn_sala_novoActionPerformed

    private void c_sal_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_sal_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_sal_codigoActionPerformed

    private void btn_sala_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sala_salvarActionPerformed
        int cod = Integer.parseInt(c_sal_codigo.getText());
        if(modoSal.equals("Novo")){
            Sala S = new Sala(cod,cb_sal_nome.getText());
            ListaSalas.add(S);
        }else if(modoSal.equals("Editar")){
            int index = tbl_salas_sal.getSelectedRow();
            ListaSalas.get(index).setCodigo(cod);
            ListaSalas.get(index).setNome(cb_sal_nome.getText());
        }
        LoadTableSalas();
        modoSal = "Navegar";
        ManipulaInterfaceSal();
        c_sal_codigo.setText("");
        cb_sal_nome.setText("");
    }//GEN-LAST:event_btn_sala_salvarActionPerformed

    private void btn_sala_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sala_cancelarActionPerformed
        c_sal_codigo.setText("");
        cb_sal_nome.setText("");
        modoSal = "Navegar";        
        ManipulaInterfaceSal();
        c_sal_codigo.setText("");
        cb_sal_nome.setText("");
    }//GEN-LAST:event_btn_sala_cancelarActionPerformed

    private void tbl_salas_salMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salas_salMouseClicked
        
        int index = tbl_salas_sal.getSelectedRow();
        if (index>=0 && index<ListaSalas.size()){
            Sala S = ListaSalas.get(index);
            c_sal_codigo.setText(String.valueOf(S.getCodigo()));
            cb_sal_nome.setText(S.getNome());
            modoSal = "Selecao";
            ManipulaInterfaceSal();
        }
    }//GEN-LAST:event_tbl_salas_salMouseClicked

    private void btn_sala_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sala_editarActionPerformed
        modoSal = "Editar";
        ManipulaInterfaceSal();
    }//GEN-LAST:event_btn_sala_editarActionPerformed

    private void btn_sala_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sala_excluirActionPerformed
        int index = tbl_salas_sal.getSelectedRow();
        if (index>=0 && index<ListaSalas.size()){
            ListaSalas.remove(index);
        } 
        LoadTableSalas();
        modoSal = "Navegar";
        ManipulaInterfaceSal();
    }//GEN-LAST:event_btn_sala_excluirActionPerformed

    /*
    Manutenção de alunos
    */
    
    private void tbl_aluno_alunosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_aluno_alunosMouseClicked
        
        int index = tbl_aluno_alunos.getSelectedRow();
        if (index>=0 && index<ListaAlunos.size()){
            Alunos A = ListaAlunos.get(index);
            c_aluno_mat.setText(String.valueOf(A.getMatricula()));
            c_aluno_nome.setText(A.getNome());
            modoAluno = "Selecao";
            ManipulaInterfaceAluno();
        }
    }//GEN-LAST:event_tbl_aluno_alunosMouseClicked

    private void btn_aluno_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aluno_salvarActionPerformed
        int index = cb_alunos_salas.getSelectedIndex();
        if (index==0){
            JOptionPane.showMessageDialog(this,"Voce deve selecionar uma sala");
        }else{
            Alunos A = new Alunos();
            A.setMatricula(Integer.parseInt(c_aluno_mat.getText()));
            A.setNome(c_aluno_nome.getText());
            A.setSal(ListaSalas.get(index-1));
            
            ListaAlunos.add(A);
            ListaSalas.get(index-1).addAluno(A);
        }
        LoadTableAluno();
        
        modoAluno = "Navegar";
        ManipulaInterfaceAluno();
    }//GEN-LAST:event_btn_aluno_salvarActionPerformed

    private void btn_aluno_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aluno_cancelarActionPerformed
        modoAluno = "Navegar";
        ManipulaInterfaceAluno();
    }//GEN-LAST:event_btn_aluno_cancelarActionPerformed

    private void c_aluno_matActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_aluno_matActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_aluno_matActionPerformed

    private void btn_aluno_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aluno_novoActionPerformed
        modoAluno = "Novo";
        ManipulaInterfaceAluno();
    }//GEN-LAST:event_btn_aluno_novoActionPerformed

    private void btn_aluno_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aluno_editarActionPerformed
        int index = tbl_aluno_alunos.getSelectedRow();
        if (index>=0 && index<ListaAlunos.size()){
            ListaAlunos.remove(index);
        } 
        LoadTableAluno();
        
        modoAluno = "Editar";
        ManipulaInterfaceAluno();
    }//GEN-LAST:event_btn_aluno_editarActionPerformed

    private void btn_aluno_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_aluno_excluirActionPerformed
       
        int index = tbl_aluno_alunos.getSelectedRow();
        if (index>=0 && index<ListaAlunos.size()){
            ListaAlunos.remove(index);
        } 
        LoadTableAluno();
        
        modoAluno = "Navegar";
        ManipulaInterfaceAluno();
    }//GEN-LAST:event_btn_aluno_excluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_aluno_cancelar;
    private javax.swing.JButton btn_aluno_editar;
    private javax.swing.JButton btn_aluno_excluir;
    private javax.swing.JButton btn_aluno_novo;
    private javax.swing.JButton btn_aluno_salvar;
    private javax.swing.JButton btn_sala_cancelar;
    private javax.swing.JButton btn_sala_editar;
    private javax.swing.JButton btn_sala_excluir;
    private javax.swing.JButton btn_sala_novo;
    private javax.swing.JButton btn_sala_salvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField c_aluno_mat;
    private javax.swing.JTextField c_aluno_nome;
    private javax.swing.JTextField c_sal_codigo;
    private javax.swing.JComboBox<String> cb_alunos_salas;
    private javax.swing.JTextField cb_sal_nome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_aluno_alunos;
    private javax.swing.JTable tbl_salas_sal;
    // End of variables declaration//GEN-END:variables

    
}
