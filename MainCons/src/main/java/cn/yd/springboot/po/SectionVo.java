package cn.yd.springboot.po;

import java.util.List;

public class SectionVo {
    private Section section;

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public List<Label> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<Label> labelList) {
        this.labelList = labelList;
    }

    private List<Label> labelList;
}
