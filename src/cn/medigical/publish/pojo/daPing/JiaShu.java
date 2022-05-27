package cn.medigical.publish.pojo.daPing;


public class JiaShu {
	 private boolean shoushujian = true;
	    private boolean taishu = false;
	    private boolean keshi = false;
	    private boolean bingren = false;
	    private boolean shoushumingcheng = false;
	    private boolean zhudaoyisheng = false;
	    private boolean mazuiyisheng = false;
	    private boolean kaishishijian = false;
	    private boolean zhuantai = false;
	    private boolean xingbie=false;
	    private boolean nianling=false;
	    
	    public boolean isXingbie() {
			return xingbie;
		}

		public void setXingbie(boolean xingbie) {
			this.xingbie = xingbie;
		}

		public boolean isNianling() {
			return nianling;
		}

		public void setNianling(boolean nianling) {
			this.nianling = nianling;
		}



	    private String notice="";


	    public boolean isShoushujian() {
	        return shoushujian;
	    }

	    public void setShoushujian(boolean shoushujian) {
	        this.shoushujian = shoushujian;
	    }

	    public boolean isTaishu() {
	        return taishu;
	    }

	    public void setTaishu(boolean taishu) {
	        this.taishu = taishu;
	    }

	    public boolean isKeshi() {
	        return keshi;
	    }

	    public void setKeshi(boolean keshi) {
	        this.keshi = keshi;
	    }

	    public boolean isBingren() {
	        return bingren;
	    }

	    public void setBingren(boolean bingren) {
	        this.bingren = bingren;
	    }

	    public boolean isShoushumingcheng() {
	        return shoushumingcheng;
	    }

	    public void setShoushumingcheng(boolean shoushumingcheng) {
	        this.shoushumingcheng = shoushumingcheng;
	    }

	    public boolean isZhudaoyisheng() {
	        return zhudaoyisheng;
	    }

	    public void setZhudaoyisheng(boolean zhudaoyisheng) {
	        this.zhudaoyisheng = zhudaoyisheng;
	    }

	    public boolean isMazuiyisheng() {
	        return mazuiyisheng;
	    }

	    public void setMazuiyisheng(boolean mazuiyisheng) {
	        this.mazuiyisheng = mazuiyisheng;
	    }

	    public boolean isKaishishijian() {
	        return kaishishijian;
	    }

	    public void setKaishishijian(boolean kaishishijian) {
	        this.kaishishijian = kaishishijian;
	    }

	    public boolean isZhuantai() {
	        return zhuantai;
	    }

	    public void setZhuantai(boolean zhuantai) {
	        this.zhuantai = zhuantai;
	    }

	    public String getNotice() {
	        return notice;
	    }

	    public void setNotice(String notice) {
	        this.notice = notice;
	    }
	    }