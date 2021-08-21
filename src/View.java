import javax.swing.table.DefaultTableModel;

import static util.RequirementTypeEnum.REQUIREMENT_1;
import static util.RequirementTypeEnum.REQUIREMENT_2;
import static util.RequirementTypeEnum.REQUIREMENT_3;

import javax.swing.border.Border;
import java.util.Objects;
import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    private static final Object[][] DEFAULT_TABLE_MODEL_DATA = new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null }, { null, null, null, null } };

    public static final String[] COLUMNS_IDENTIFIERS_REQ_2 = new String[] { "estrato", "fechaInicio", "financiable", "porcentaje" };
    public static final String[] COLUMNS_IDENTIFIERS_REQ_1 = new String[] { "idProyecto", "pagado", "proveedor", "total" };
    public static final String[] COLUMNS_IDENTIFIERS_REQ_3 = new String[] { "clasificacion", "idProyecto", "pagado" };

    private static final Border LINE_BORDER = BorderFactory.createLineBorder(new Color(0, 0, 0));
    private static final Color BACKGROUD_COLOR = new Color(242, 243, 244);
    private static final Font FONT = new Font("Tahoma", 1, 11);

    private DefaultTableModel tableModelReq1 = new DefaultTableModel();
    private DefaultTableModel tableModelReq2 = new DefaultTableModel();
    private DefaultTableModel tableModelReq3 = new DefaultTableModel();
    private JPanel mainPanel;
    private JPanel tablePanel1;
    private JPanel tablePanel2;
    private JPanel tablePanel3;
    private static View form;
    private JTable tableReq1;
    private JTable tableReq2;
    private JTable tableReq3;
    private JButton req1Btn;
    private JButton req2Btn;
    private JButton req3Btn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;

    public View() {
        initComponents();

        req1Btn.addActionListener(new Controller(this));
        req2Btn.addActionListener(new Controller(this));
        req3Btn.addActionListener(new Controller(this));
    }

    public DefaultTableModel getTableModelReq1() {
        return tableModelReq1;
    }

    public DefaultTableModel getTableModelReq2() {
        return tableModelReq2;
    }

    public DefaultTableModel getTableModelReq3() {
        return tableModelReq3;
    }

    public JButton getReq1Btn() {
        return req1Btn;
    }

    public JButton getReq2Btn() {
        return req2Btn;
    }

    public JButton getReq3Btn() {
        return req3Btn;
    }

    public JTable getTableReq1() {
        return tableReq1;
    }

    public JTable getTableReq2() {
        return tableReq2;
    }

    public JTable getTableReq3() {
        return tableReq3;
    }

    private void initComponents() {
        req1Btn = new JButton(REQUIREMENT_1.getDescription());
        req2Btn = new JButton(REQUIREMENT_2.getDescription());
        req3Btn = new JButton(REQUIREMENT_3.getDescription());
        jLabel1 = new JLabel(REQUIREMENT_1.getDescription());
        jLabel2 = new JLabel(REQUIREMENT_2.getDescription());
        jLabel3 = new JLabel(REQUIREMENT_3.getDescription());
        tablePanel1 = new JPanel();
        tablePanel2 = new JPanel();
        tablePanel3 = new JPanel();
        tableReq1 = new JTable();
        tableReq2 = new JTable();
        tableReq3 = new JTable();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(req1Btn);
        buttonPanel.add(req2Btn);
        buttonPanel.add(req3Btn);
        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        mainPanel.setLayout(new BorderLayout());
    }

    void removePanels() {
        if (Objects.nonNull(mainPanel)) {
            remove(mainPanel);
        }

        if (Objects.nonNull(tablePanel1)) {
            remove(tablePanel1);
        }

        if (Objects.nonNull(tablePanel2)) {
            remove(tablePanel2);
        }

        if (Objects.nonNull(tablePanel3)) {
            remove(tablePanel3);
        }
    }

    private void refreshFrame() {
        form.invalidate();
        form.validate();
        form.repaint();
    }

    void setTableReq1() {
        removePanels();
        initializeMainPanel();

        tableReq1.setBackground(BACKGROUD_COLOR);
        tableReq1.setBorder(LINE_BORDER);
        tableReq1.setFont(FONT);
        tableReq1.setModel(new DefaultTableModel(DEFAULT_TABLE_MODEL_DATA, COLUMNS_IDENTIFIERS_REQ_1));
        tablePanel1.add(jLabel1);
        tablePanel1.add(new JScrollPane(tableReq1), BorderLayout.CENTER);
        mainPanel.add(tablePanel1);
        add(mainPanel);
        refreshFrame();
    }

    void setTableReq2() {
        removePanels();
        initializeMainPanel();

        tableReq2.setBackground(BACKGROUD_COLOR);
        tableReq2.setBorder(LINE_BORDER);
        tableReq2.setFont(FONT);
        tableReq2.setModel(new DefaultTableModel(DEFAULT_TABLE_MODEL_DATA, COLUMNS_IDENTIFIERS_REQ_2));
        tablePanel2.add(jLabel2);
        tablePanel2.add(new JScrollPane(tableReq2), BorderLayout.CENTER);
        mainPanel.add(tablePanel2);
        add(mainPanel);
        refreshFrame();
    }

    void setTableReq3() {
        removePanels();
        initializeMainPanel();

        tableReq3.setBackground(BACKGROUD_COLOR);
        tableReq3.setBorder(LINE_BORDER);
        tableReq3.setFont(FONT);
        tableReq3.setModel(new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null },
                { null, null, null }, { null, null, null } }, COLUMNS_IDENTIFIERS_REQ_3));
        tablePanel3.add(jLabel3);
        tablePanel3.add(new JScrollPane(tableReq3), BorderLayout.CENTER);
        mainPanel.add(tablePanel3);
        add(mainPanel);
        refreshFrame();
    }

    public static void main(String args[]) {
        form = new View();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                form.setTitle("Proyectos");
                form.setSize(800, 600);
                form.setVisible(true);
            }
        });
    }
}