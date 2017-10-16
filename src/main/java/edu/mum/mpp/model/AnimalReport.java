package edu.mum.mpp.model;

import java.sql.Timestamp;

public class AnimalReport {

    private long id;
    private String name;
    private Timestamp dateOfBirth;
    private Timestamp dateOfDeath;
    private String specy;
    private String tag;
    private String cellName;
    private String blockName;
    private long cellId;
    private long blockId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Timestamp getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Timestamp dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getSpecy() {
        return specy;
    }

    public void setSpecy(String specy) {
        this.specy = specy;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public long getCellId() {
        return cellId;
    }

    public void setCellId(long cellId) {
        this.cellId = cellId;
    }

    public long getBlockId() {
        return blockId;
    }

    public void setBlockId(long blockId) {
        this.blockId = blockId;
    }
}
