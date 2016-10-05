package batchboot;

import java.io.Serializable;

public class TablePojo implements Serializable {

    private Integer id;
    private String descr;

    @Override
    public String toString() {
        return "TablePojo{" +
                "id=" + id +
                ", descr='" + descr + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
