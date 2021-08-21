import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import util.RequirementTypeEnum;

public class Controller implements ActionListener {

    private Dao dao;
    private View view;

    public Controller(View view) {
        this.view = view;
        dao = new Dao("jdbc:mysql://localhost:3306/Proyectos");
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object component = event.getSource();

        if (component.equals(view.getReq1Btn())) {
            showTable(RequirementTypeEnum.REQUIREMENT_1);
        }

        if (component.equals(view.getReq2Btn())) {
            showTable(RequirementTypeEnum.REQUIREMENT_2);
        }

        if (component.equals(view.getReq3Btn())) {
            showTable(RequirementTypeEnum.REQUIREMENT_3);
        }

    }

    void showTable(RequirementTypeEnum requirementType) {
        switch (requirementType) {
            case REQUIREMENT_1:
                view.setTableReq1();
                view.getTableModelReq1().setDataVector(dao.getReqs(requirementType), View.COLUMNS_IDENTIFIERS_REQ_1);
                view.getTableReq1().setModel(view.getTableModelReq1());
                break;
            case REQUIREMENT_2:
                view.setTableReq2();
                view.getTableModelReq2().setDataVector(dao.getReqs(requirementType), View.COLUMNS_IDENTIFIERS_REQ_2);
                view.getTableReq2().setModel(view.getTableModelReq2());
                break;

            default:
                view.setTableReq3();
                view.getTableModelReq3().setDataVector(dao.getReqs(requirementType), View.COLUMNS_IDENTIFIERS_REQ_3);
                view.getTableReq3().setModel(view.getTableModelReq3());
                break;
        }
    }

}