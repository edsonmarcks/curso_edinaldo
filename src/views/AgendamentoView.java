package views;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Agendamento;
import modelo.Medico;
import modelo.Paciente;
import modelo.dao.AgendamentoDao;
import views.helper.MedicoPesquisaJDialog;
import views.helper.PacientePesquisaJDialog;
import views.utils.BaseFormulario;
import views.utils.DataConverte;

public class AgendamentoView extends BaseFormulario {

    private LocalDate dataAgendamento;
    private final LocalDate hoje = LocalDate.now();
    private Medico medicoSelecionado;
    private Paciente pacienteSelecionado;
    private AgendamentoDao agendamentoDao;
    private Agendamento agendamento;

    /**
     * Creates new form AgendamentoView
     */
    public AgendamentoView() {
        initComponents();
        agendamentoDao = new AgendamentoDao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSelecioneProfissional = new javax.swing.JLabel();
        txtNomeMedico = new javax.swing.JTextField();
        btnBuscarMedico = new javax.swing.JButton();
        lbEspecialidade = new javax.swing.JLabel();
        lbTituloCRM = new javax.swing.JLabel();
        lbCRM = new javax.swing.JLabel();
        lbPacienteName = new javax.swing.JLabel();
        txtNomePaciente = new javax.swing.JTextField();
        btnBuscarPaciente = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbCPF = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jDateChooserDataAgendamento = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxHorarios = new javax.swing.JComboBox<>();
        btnConfirmar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setTitle("Agendamento de Consultas");

        lbSelecioneProfissional.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        lbSelecioneProfissional.setText("Selecione Profissional*");

        txtNomeMedico.setEditable(false);

        btnBuscarMedico.setText("...");
        btnBuscarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarMedicoActionPerformed(evt);
            }
        });

        lbEspecialidade.setText(":::");

        lbTituloCRM.setText("CRM:");

        lbCRM.setText("::::");

        lbPacienteName.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        lbPacienteName.setText("Paciente*");

        txtNomePaciente.setEditable(false);

        btnBuscarPaciente.setText("...");
        btnBuscarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPacienteActionPerformed(evt);
            }
        });

        jLabel1.setText("Nasc:");

        lbDataNascimento.setText("::");

        jLabel2.setText("CPF:");

        lbCPF.setText("::");

        jLabel3.setText("Data do agendamento");

        jDateChooserDataAgendamento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jDateChooserDataAgendamentoFocusLost(evt);
            }
        });

        jLabel4.setText("Selecione o horario");

        jComboBoxHorarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "14:00", "15:00", "16:00", "17:00" }));

        btnConfirmar.setBackground(new java.awt.Color(0, 105, 217));
        btnConfirmar.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(200, 35, 51));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 1, 13)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTituloCRM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCRM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbSelecioneProfissional)
                                .addComponent(lbPacienteName)
                                .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(46, 46, 46))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbDataNascimento))
                                            .addComponent(jDateChooserDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbCPF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscarMedico)
                            .addComponent(btnBuscarPaciente))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbSelecioneProfissional)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarMedico)
                    .addComponent(txtNomeMedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTituloCRM)
                    .addComponent(lbCRM)
                    .addComponent(lbEspecialidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbPacienteName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPaciente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbDataNascimento)
                    .addComponent(jLabel2)
                    .addComponent(lbCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooserDataAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxHorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarMedicoActionPerformed
        MedicoPesquisaJDialog medicoPesquisaJDialog = new MedicoPesquisaJDialog(null, true);
        medicoPesquisaJDialog.setVisible(true);
        medicoSelecionado = medicoPesquisaJDialog.getMedicoSelecionado();
        if (medicoSelecionado != null && medicoSelecionado.getId() != null) {
            txtNomeMedico.setText(medicoSelecionado.getNome().toUpperCase());
            lbCRM.setText(medicoSelecionado.getCRM());
            lbEspecialidade.setText(medicoSelecionado.getEspecializacao());
        } else {
            limpar();
        }
    }//GEN-LAST:event_btnBuscarMedicoActionPerformed

    private void btnBuscarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPacienteActionPerformed
        PacientePesquisaJDialog pacientePesquisaJDialog = new PacientePesquisaJDialog(null, true);
        pacientePesquisaJDialog.setVisible(true);
        pacienteSelecionado = pacientePesquisaJDialog.getPacienteSelecionado();
        if (pacienteSelecionado != null && pacienteSelecionado.getId() != null) {
            txtNomePaciente.setText(pacienteSelecionado.getNome().toUpperCase());
            lbDataNascimento.setText( //Pega a data de nascimento em formato de texto
                    pacienteSelecionado.getNascimento()
                            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            lbCPF.setText(pacienteSelecionado.getCPF());
        } else {

        }
    }//GEN-LAST:event_btnBuscarPacienteActionPerformed

    private void jDateChooserDataAgendamentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDateChooserDataAgendamentoFocusLost

    }//GEN-LAST:event_jDateChooserDataAgendamentoFocusLost

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // <editor-fold defaultstate="collapsed" desc="Validacao do formulario">  
        /*
            Garante que o m??dico ser?? selecionado
         */
        if (medicoSelecionado == null || medicoSelecionado.getId() == null) {
            JOptionPane.showMessageDialog(rootPane, "Por favor informe o m??dico!",
                    title, JOptionPane.WARNING_MESSAGE);
            return;
        }
        /*
            Garante que o paciente ser?? selecionado
         */
        if (pacienteSelecionado == null || pacienteSelecionado.getId() == null) {
            JOptionPane.showMessageDialog(rootPane, "Por favor informe o paciente!",
                    title, JOptionPane.WARNING_MESSAGE);
            return;
        }
        /* Quando o campo perder o foco o sistema vai verificar se o
        usu??rio informou uma data v??lida que seria: Um data na m??s vigente,
        ou m??s subsequente apartir da data informada*/
        dataAgendamento = DataConverte.getLocalDate(jDateChooserDataAgendamento.getDate());
        if (dataAgendamento == null || dataAgendamento.isBefore(hoje)) {
            JOptionPane.showMessageDialog(rootPane, "Por favor informe uma data v??lida.",
                    title, JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!agendamentoDao.isHorarioVago(medicoSelecionado.getId(), dataAgendamento, jComboBoxHorarios.getSelectedItem().toString())) {
            JOptionPane.showMessageDialog(rootPane, "Hor??rio n??o dispon??vel", title, JOptionPane.WARNING_MESSAGE);
            return;
        }// </editor-fold>  
        int op = JOptionPane.showConfirmDialog(rootPane, "Confirmar agendamento?",
                title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (op == JOptionPane.YES_OPTION) {
            try {
                agendamento = new Agendamento();
                agendamento.setDataLancamento(dataAgendamento);
                agendamento.setHora(jComboBoxHorarios.getSelectedItem().toString());
                agendamento.setMedico(medicoSelecionado);
                agendamento.setPaciente(pacienteSelecionado);
                agendamento.setStatus("AGENDADO");
                if (agendamentoDao.salvar(agendamento)) {
                    JOptionPane.showMessageDialog(rootPane, "Novo agendamento realizado com sucesso", title,
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    throw new Exception("Desculpe n??o foi poss??vel salvar o agendamento.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e.getMessage(), title,
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarMedico;
    private javax.swing.JButton btnBuscarPaciente;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxHorarios;
    private com.toedter.calendar.JDateChooser jDateChooserDataAgendamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCRM;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbEspecialidade;
    private javax.swing.JLabel lbPacienteName;
    private javax.swing.JLabel lbSelecioneProfissional;
    private javax.swing.JLabel lbTituloCRM;
    private javax.swing.JTextField txtNomeMedico;
    private javax.swing.JTextField txtNomePaciente;
    // End of variables declaration//GEN-END:variables

    //Limpa os campos
    private void limpar() {
        lbCRM.setText(":::");
        lbEspecialidade.setText(":::");
        txtNomeMedico.setText(null);
        lbCPF.setText(":::");
        lbDataNascimento.setText(":::");
        txtNomePaciente.setText(null);
    }

}
