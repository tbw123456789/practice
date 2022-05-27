package cn.medigical.publish.pojo.daPing;
public class PeiZhi {
	private Integer id;
    private PaiBanTable paiBanTable;
    private JiaShu jiaShu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaiBanTable getPaiBanTable() {
        if(paiBanTable==null){
            paiBanTable = new PaiBanTable();
        }
        return paiBanTable;
    }

    public void setPaiBanTable(PaiBanTable paiBanTable) {
        this.paiBanTable = paiBanTable;
    }

    public JiaShu getJiaShu() {
        if(jiaShu==null){
            jiaShu = new JiaShu();
        }
        return jiaShu;
    }

    public void setJiaShu(JiaShu jiaShu) {
        this.jiaShu = jiaShu;
    }

    @Override
    public String toString() {
        return "PeiZhi{" +
                "id=" + id +
                ", paiBanTable=" + paiBanTable +
                ", jiaShu=" + jiaShu +
                '}';
    }
}
