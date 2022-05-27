package cn.medigical.publish.pojo.dictionary;


public class ConfigDrugReasons  {
        private String id;
        private String code;
        private String name;
        private Integer position;
        private Boolean deleted;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getCode() {
			return code;
		}
		public void setCode(String code) {
			this.code = code;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getPosition() {
			return position;
		}
		public void setPosition(Integer position) {
			this.position = position;
		}
		public Boolean getDeleted() {
			return deleted;
		}
		public void setDeleted(Boolean deleted) {
			this.deleted = deleted;
		}


}
