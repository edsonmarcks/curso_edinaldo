/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import com.toedter.calendar.JDateChooser;
import controller.AgendamentoTableMoldelMedico;
import controller.MedicoComboBox;
import controller.MedicoTableModel;
import java.awt.Component;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Agendamento;
import modelo.Medico;
import modelo.dao.AgendamentoDao;
import modelo.dao.MedicoDao;
import modelo.utils.MesEnum;
import modelo.utils.StatusAgendamento;
import views.utils.BaseFormulario;
import views.utils.DataConverte;

/**
 *
 * @author edsonmarcks
 */
public class MedicoView extends BaseFormulario {

    private final MedicoComboBox modelComboBox;
    private final AgendamentoDao AGE_DAO = new AgendamentoDao();
    private MedicoTableModel medicoTableModel;
    private AgendamentoTableMoldelMedico agendamentoTableMoldelMedico;
    private MedicoDao medicoDao;
    private Medico medico;

    /**
     * Creates new form MedicoView
     */
    public MedicoView() {
        initComponents();
        medicoDao = new MedicoDao(); //cria o objeto de persistencia
        modelComboBox = new MedicoComboBox(medicoDao.buscarTodos());

        medicoTableModel = new MedicoTableModel(medicoDao.buscarTodos()); //cria o modelo para a tabela
        agendamentoTableMoldelMedico = new AgendamentoTableMoldelMedico(new ArrayList<Agendamento>());
        jTableMedico.setModel(medicoTableModel); //seta o modelo na tabela
        jTableAgendamento.setModel(agendamentoTableMoldelMedico);
        cbMedico.setModel(modelComboBox);
        habilitar(false); //inicia o formulário com os campo bloqueados
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserDataAdmissao = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCRM = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxEspecializacao = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldTelefone = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedico = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAgendamento = new javax.swing.JTable();
        lbMedico = new javax.swing.JLabel();
        cbMedico = new javax.swing.JComboBox();
        lbMesSelecionado = new javax.swing.JLabel();
        jComboBoxMesSelecionado = new javax.swing.JComboBox();
        lbStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();

        jLabel1.setText("Código");

        jTextFieldCodigo.setEditable(false);

        jLabel2.setText("Nome*");

        jLabel3.setText("Dt. Admissão*");

        jLabel4.setText("CRM*");

        jLabel5.setText("Especialização*");

        jComboBoxEspecializacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Clínico Geral", "Ginecologista", "Neurologista", "Pediatra", "Psiquiatra", "Urologista" }));

        jLabel6.setText("Telefone*");

        try {
            jFormattedTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedico);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldCRM, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                        .addComponent(jTextFieldCodigo)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxEspecializacao, 0, 426, Short.MAX_VALUE)
                                        .addComponent(jTextFieldNome)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jDateChooserDataAdmissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFormattedTextFieldTelefone)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel3))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnExcluir, btnNovo, btnSalvar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooserDataAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxEspecializacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jComboBoxEspecializacao, jDateChooserDataAdmissao, jFormattedTextFieldTelefone, jTextFieldCRM, jTextFieldCodigo, jTextFieldNome});

        jTabbedPane1.addTab("Cadastro", jPanel1);

        jTableAgendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableAgendamento);

        lbMedico.setText("Selecione o médico");

        cbMedico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMedico.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMedicoItemStateChanged(evt);
            }
        });

        lbMesSelecionado.setText("Mês");

        jComboBoxMesSelecionado.setModel(new javax.swing.DefaultComboBoxModel(MesEnum.values()));
        jComboBoxMesSelecionado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxMesSelecionadoItemStateChanged(evt);
            }
        });

        lbStatus.setText("Status");

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel(StatusAgendamento.values()));
        jComboBoxStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxStatusItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMedico))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxMesSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMesSelecionado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lbStatus)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jComboBoxStatus, 0, 168, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMedico)
                    .addComponent(lbMesSelecionado)
                    .addComponent(lbStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxMesSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbMedico, jComboBoxStatus});

        jTabbedPane1.addTab("Agendamentos", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Consultas", jPanel3);

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
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        // TODO add your handling code here:
        habilitar(true); //desbloqueia os campos do formulário
        jTextFieldNome.requestFocus(); //foca no campo nome do médico
        medico = new Medico(); //cria novo medico
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitar(false);
        limparTela();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        try {
            //verifica os campos obrigatórios
            validarCamposFormulario();
            //Confirmação do usuário
            int op = JOptionPane.showConfirmDialog(rootPane, "Confirmar a operação?",
                    "Salvando registro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                medico.setNome(jTextFieldNome.getText());
                medico.setCRM(jTextFieldCRM.getText());
                medico.setEspecializacao(jComboBoxEspecializacao.getSelectedItem().toString());
                medico.setTelefone(jFormattedTextFieldTelefone.getText());
                medico.setDataAdmissao(DataConverte.getLocalDate(jDateChooserDataAdmissao.getDate()));
                System.out.println(medico.getDataAdmissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                String mensagem = "";
                if (medico.getId() != null) {

                    if (medicoDao.atualizar(medico)) {
                        mensagem = "Registro atualizado com sucesso!";
                    }

                } else {
                    if (medicoDao.salvar(medico)) {
                        mensagem = "Novo registro salvo com sucesso!";
                    }
                }
                JOptionPane.showMessageDialog(rootPane, mensagem, "Cadastro de médico",
                        JOptionPane.INFORMATION_MESSAGE);
                medicoTableModel.adicionar(medico);
                medico = null;
                habilitar(false);
                limparTela();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Desculpe houve uma falha\n" + e.getMessage(),
                    title, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jTableMedicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicoMouseClicked
        //pegar o dado linha selecionada
        medico = medicoTableModel.getEntity(jTableMedico.getSelectedRow());
        //verificar se o registro entrado é válido ou não está nulo.
        if (medico != null && medico.getId() != null) //garanto que é registro vindo do banco pelo id
        {
            //capturo os dados na tela para o usuário
            jTextFieldCodigo.setText(String.format("%05d", medico.getId()));
            jTextFieldCRM.setText(medico.getCRM());
            jTextFieldNome.setText(medico.getNome());
            jComboBoxEspecializacao.setSelectedItem(medico.getEspecializacao());
            jFormattedTextFieldTelefone.setText(medico.getTelefone());
            try {
                jDateChooserDataAdmissao.setDate(DataConverte.getDate(medico.getDataAdmissao()));
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(rootPane, "Data Informada é inválida", "Desculpe", JOptionPane.ERROR_MESSAGE);
                return;
            }
            habilitar(true); //habilita os campos para edição

        } else {
            agendamentoTableMoldelMedico.setLista(new ArrayList<>());
        }
    }//GEN-LAST:event_jTableMedicoMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //Exigir confirmação do usuário
        int op = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir o registro selecionado\n"
                + medico.getNome().toUpperCase() + " ?",
                title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (medicoDao.remover(medico)) {
            JOptionPane.showMessageDialog(rootPane, "Registro excluido com sucesso!",
                    title, JOptionPane.INFORMATION_MESSAGE);
            medicoTableModel.remover(medico);
            medico = null;
            habilitar(false);
            limparTela();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void cbMedicoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMedicoItemStateChanged
        pesquisar();
    }//GEN-LAST:event_cbMedicoItemStateChanged

    private void jComboBoxMesSelecionadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxMesSelecionadoItemStateChanged
        pesquisar();
    }//GEN-LAST:event_jComboBoxMesSelecionadoItemStateChanged

    private void jComboBoxStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxStatusItemStateChanged
        pesquisar();
    }//GEN-LAST:event_jComboBoxStatusItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cbMedico;
    private javax.swing.JComboBox jComboBoxEspecializacao;
    private javax.swing.JComboBox jComboBoxMesSelecionado;
    private javax.swing.JComboBox jComboBoxStatus;
    private com.toedter.calendar.JDateChooser jDateChooserDataAdmissao;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableAgendamento;
    private javax.swing.JTable jTableMedico;
    private javax.swing.JTextField jTextFieldCRM;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JLabel lbMedico;
    private javax.swing.JLabel lbMesSelecionado;
    private javax.swing.JLabel lbStatus;
    // End of variables declaration//GEN-END:variables

    //Bloqueia ou desbloqueia os campos do formulário
    public void habilitar(boolean b) {
        jTextFieldNome.setEnabled(b);
        jTextFieldCRM.setEnabled(b);
        jDateChooserDataAdmissao.setEnabled(b);
        jComboBoxEspecializacao.setEnabled(b);
        jFormattedTextFieldTelefone.setEnabled(b);
        btnNovo.setEnabled(!b);
        btnSalvar.setEnabled(b);
        btnExcluir.setEnabled(b);
        btnCancelar.setEnabled(b);
    }

    //Verifica se o usuário preencheu corretamente os campos obrigatórios
    public void validarCamposFormulario() throws Exception {

        if (jTextFieldNome.getText() == null || jTextFieldNome.getText().trim().equals("")
                || jTextFieldNome.getText().trim().isEmpty()) {
            throw new Exception("O Campo nome é obrigatório!");
        }
        if (jTextFieldCRM.getText() == null || jTextFieldCRM.getText().trim().equals("")
                || jTextFieldCRM.getText().trim().isEmpty()) {
            throw new Exception("O CRM é obrigatório!");
        }
        if (jFormattedTextFieldTelefone.getText().equals("(  )     -    ")) {
            throw new Exception("Informe o telefone");
        }
        if (jDateChooserDataAdmissao.getDate() == null) {
            throw new Exception("A data de admissão é obrigatória!");
        }
    }

    public void limparTela() {
        for (Component c : jPanel1.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText("");
            } else if (c instanceof JFormattedTextField) {
                ((JFormattedTextField) c).setText("");
            } else if (c instanceof JDateChooser) {
                try {
                    ((JDateChooser) c).setDate(DataConverte.getDate(LocalDate.now()));
                } catch (ParseException ex) {
                    System.err.println("data inválida!");
                }
            }
        }
        agendamentoTableMoldelMedico.setLista(new ArrayList<>());
    }

    private void pesquisar() {
        Medico medicoPesquisado = (Medico) cbMedico.getSelectedItem();
        MesEnum mes = (MesEnum) jComboBoxMesSelecionado.getSelectedItem();
        System.out.println(mes);
        agendamentoTableMoldelMedico.setLista(
                AGE_DAO.buscarAgendamentoMedicoPaciente(medicoPesquisado.getId(), mes.getValor(),
                        (StatusAgendamento) jComboBoxStatus.getSelectedItem()));
    }
}
