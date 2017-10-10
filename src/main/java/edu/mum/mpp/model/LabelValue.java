package edu.mum.mpp.model;

public class LabelValue {

    private String label;
    private long value;

    /* LabelValue(String label,long value)
      {
          label=label;
      }*/
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}
