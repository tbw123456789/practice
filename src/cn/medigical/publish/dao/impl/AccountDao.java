package cn.medigical.publish.dao.impl;


import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.utils.Constants;

import javax.annotation.PostConstruct;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by 2018/6/7.
 * 账户信息数据库操作类
 */
@Service
public class AccountDao extends BaseDao<Account> {
    static Logger logger = Logger.getLogger("AccountDao");
    final String USER_PIC_PREFIX = "user_pic_";
    final String USER_SIGN_PREFIX = "user_sign_";
    private static List<String> roleList = new ArrayList<>();
    private String operDoc = Constants.SHOUSHU_DOCTOR;
    private String nurse = Constants.HUSHI;
    public Map<String, Account> accountMap = new HashMap<String, Account>();

    static {
        String mazuiDoc = Constants.MAZUI_DOCTOR;
        String mazuiZhuren = Constants.MAZUI_ZHUREN;
        String admin = Constants.ADMIN;
        roleList.add(mazuiDoc);
        roleList.add(mazuiZhuren);
        //roleList.add(admin);
        roleList.add(Constants.HUSHI);
    }

    public void addUpdate(Account account) {
        save(account);
    }

    /**
     * 修改或者添加Account
     * @param account
     * @return
     */
    public boolean updateInsert(Account account) {
        Criteria criteria = getCriteria().and("_id").is(
                new ObjectId(account.getId()));
        try {
            return updateInsert(criteria,getAcountUpdate(account));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Update getAcountUpdate(Account account) throws IllegalAccessException {
        Class<?> accountCls = account.getClass();
        Field[] fields = accountCls.getDeclaredFields();
        Update update = new Update();
        for(Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            if(!"id".equals(fieldName)&&!"pwd".equals(fieldName)) {
                update.set(fieldName, field.get(account));
            }
        }
        return update;
    }

    public void del(Account account) {
        Criteria criteria = getCriteria().and("_id").is(
                new ObjectId(account.getId()));
        Update update = new Update().set("canLogin", false).set("status", Constants.FLAG_IN_VALID);
        updateFirst(criteria, update);
    }

    public void undel(Account account) {
        Criteria criteria = getCriteria().and("_id").is(
                new ObjectId(account.getId()));
        Update update = new Update().set("canLogin", true).set("status", Constants.FLAG_VALID);
        updateFirst(criteria, update);
    }

    public static String generatePassword(final String src) {
        return encodeByMD5(src);
    }

    public boolean verifyPassword(final String password, final String src) {
        if (password == null || src == null) {
            return false;
        }
        return password.equals(encodeByMD5(src));
    }

    public List<Account> findByTime(Date startTime, Date endTime) {
        List<Account> ret = new ArrayList<>();
        Criteria criteria = getCriteria().and("CreateTime").gte(startTime).lt(endTime);
        Criteria criteria1 = getCriteria().and("Status").is("valid");
        Criteria criteria2 = getCriteria().and("Role").in(roleList);
        ret.addAll(find(criteria.andOperator(criteria1.andOperator(criteria2))));

        return ret;
    }

    public List<Account> findWorkInTime(Date startTime, Date endTime) {
        List<Account> ret = new ArrayList<>();
        Criteria criteria10 = Criteria.where("InDate").lte(startTime).and("OutDate").gte(endTime);  //在开始时间之前就已经入职
        Criteria criteria11 = Criteria.where("InDate").lte(startTime).and("Status").is("valid");  //在开始时间之前就已经入职

        ret.addAll(find(criteria10));
        ret.addAll(find(criteria11));

        return ret;
    }

    public Account findByWorkID(String workID) {
        Pattern pattern = Pattern.compile(".*?" + workID + ".*?");
        Criteria criteria = getCriteria().and("workID").regex(pattern);
        return findOne(criteria);
    }

    public Account findNotLikeByWorkID(String workID) {
        Criteria criteria = getCriteria().and("workID").is(workID);
        return findOne(criteria);
    }

    public List<Account> findFromWorkID(String workID) {
        ArrayList<Account> ret = new ArrayList<Account>();
        Pattern pattern = Pattern.compile(".*?" + workID + ".*?");
        Criteria criteria = getCriteria().and("workID").regex(pattern);
        List<Account> accountList = find(criteria);
        if (null != accountList) {
            ret.addAll(accountList);
        }
        return ret;
    }

    public List<Account> findByName(String name) {
        ArrayList<Account> ret = new ArrayList<Account>();
        Pattern pattern = Pattern.compile(".*?" + name + ".*?");
        Criteria criteria = getCriteria().and("TrueName").regex(pattern);
//        Criteria criteria = getCriteria().and("trueName").is(name);
        criteria.and("Status").is(Constants.FLAG_VALID);
        List<Account> accountList = find(criteria);

        if (null != accountList) {
            ret.addAll(accountList);
        }

        return ret;
    }

    public Account findAccountByName(String name) {
        Criteria criteria = getCriteria().and("TrueName").is(name);
//        criteria.and("status").is(Constants.FLAG_VALID);
        return findOne(criteria);
    }

    public List<Account> findAccountListByName(String name) {
//    	System.out.println(name);
        Criteria criteria = getCriteria().and("trueName").is(name);
        criteria.and("status").is(Constants.FLAG_VALID);
        return find(criteria);
    }


    public Account findAccountById(String id) {
        Criteria criteria = getCriteria().and("id").is(id);
        return findOne(criteria);
    }
    public List<Account> findAccountListByNameAll(String name) {
        Criteria criteria = getCriteria().and("trueName").is(name);
        return find(criteria);
    }
    public Account findAccountByWorkID(String workId) {
        Criteria criteria = getCriteria().and("workID").is(workId);
        return findOne(criteria);
    }

    public List<Account> checkFromWorkID(String workID) {
        ArrayList<Account> ret = new ArrayList<Account>();
        // Pattern pattern = Pattern.compile(".*?" + word + ".*?");
        Criteria criteria = getCriteria().and("WorkID").is(workID);
        List<Account> accountList = find(criteria);

        if (null != accountList) {
            ret.addAll(accountList);
        }

        return ret;

    }

    public Account findOne(String workID) {
        Criteria criteria = getCriteria().and("WorkID").is(workID);
        return findOne(criteria);

    }

    public Account findLoginOne(String workID) {
        Criteria criteria = getCriteria().and("WorkID").is(workID);
        Criteria criteria1 = getCriteria().and("Role").in(roleList);
        return findOne(criteria.andOperator(criteria1));

    }

    public List<Account> gets() {
        return getAll();
    }

    //获取有效账号
    public List<Account> getAllAccount() {
        Criteria criteria = getCriteria().and("Status").is(Constants.FLAG_VALID);
        //Criteria criteria1 = getCriteria().and("Status").is(Constants.FLAG_VALID);
        return find(criteria);
    }

    //获取能登录的账号
    public List<Account> getCanLoginAccount() {
        Criteria criteria = getCriteria().and("CanLogin").is(true);
        return find(criteria);
    }

    //在职麻醉医生
    public List<Account> findAccountIn() {
        Criteria criteria = getCriteria().and("status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("role").in(roleList);
        return find(criteria.andOperator(criteria1));
    }

    //在职麻醉医生
    public List<Account> findAccountInMazui() {
        Criteria criteria = getCriteria().and("status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("role").in(Constants.MAZUI_DOCTOR);
        return find(criteria.andOperator(criteria1));
    }

    //在职可登录的麻醉医生
    public List<Account> findAnesAccount() {
        Criteria criteria = getCriteria().and("Status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("Role").in(roleList);
        Criteria criteria2 = getCriteria().and("CanLogin").is(true);
        return find(criteria.andOperator(criteria1, criteria2));
    }

    //手术医生
    public List<Account> findOperDoctor() {
        Criteria criteria = getCriteria().and("Status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("Role").is(operDoc);
        return find(criteria.andOperator(criteria1));
    }

    /**
     * @return java.util.List<common.anes.pojo.Account>
     * @throws
     * @describe：
     * @author：
     * @CreateDate： 2009/5/3 10:33
     * @parameter： []
     */
    public List<Account> findOperDoctorsq() {
        Criteria criteria = getCriteria().and("Status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("Role").is(Constants.DOCTOR);
        return find(criteria.andOperator(criteria1));
    }

    //护士
    public List<Account> findNurse() {
        Criteria criteria = getCriteria().and("Status").is(Constants.FLAG_VALID);
        Criteria criteria1 = getCriteria().and("Role").is(nurse);
        return find(criteria.andOperator(criteria1));
    }

//    public boolean saveUserPic(Account user, String fileName)
//            throws DaoHandler {
//        return savePic(user, fileName, USER_PIC_PREFIX + user.getId());
//    }
//
//    public boolean saveSignPic(Account user, String fileName)
//            throws DaoHandler {
//        return savePic(user, fileName, USER_SIGN_PREFIX + user.getId());
//    }
//
//    public boolean downUserPic(Account user, String fileName)
//            throws DaoHandler {
//        return downPic(user, fileName, USER_PIC_PREFIX + user.getId());
//    }
//
//    public boolean downSignPic(Account user, String fileName)
//            throws DaoHandler {
//        return downPic(user, fileName, USER_SIGN_PREFIX + user.getId());
//    }
//
//    public boolean delUserPic(Account user, String fileName)
//            throws DaoHandler {
//        return delPic(USER_PIC_PREFIX + user.getId());
//    }

//    public boolean delSignPic(Account user, String fileName)
//            throws DaoHandler {
//        return delPic(USER_SIGN_PREFIX + user.getId());
//    }
//
//    private boolean delPic(String fileInDBName) throws DaoHandler {
//        GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
//
//        Document document = new Document("Filename",fileInDBName+".png");
//
//        MongoCursor<GridFSFile> fileList = gridFS.find(document).iterator();
//        while (fileList.hasNext()) {
//            GridFSFile gridFSFile = fileList.next();
//            if (null != gridFSFile) {
//                gridFS.delete(gridFSFile.getObjectId());
//            }
//        }
//
//        return true;
//    }
//
//    private boolean savePic(Account user, String fileName, String fileInDBName)
//            throws DaoHandler {
//        File fileImage = new File( /* LOCAL_IMAGE_FOLDER + */fileName);
//        GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
//        ObjectId objectId = null;
//        try {
//            objectId = gridFS.uploadFromStream(fileInDBName+".png",new FileInputStream(fileImage));
//        } catch (IOException e) {
//            logger.error(e.getMessage());
//            logger.error(e.getStackTrace());
//            throw new DaoHandler(e);
//        }
//
//        return true;
//    }
//
//    private boolean downPic(Account user, String fileName, String fileInDBName)
//            throws DaoHandler {
//        GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
//        String localFilePath = /* LOCAL_IMAGE_FOLDER+ */fileName;
//        File file = new File(localFilePath);
//        if (file.exists()){
//            file.delete();
//        }
//
//        Document document = new Document("Filename",fileInDBName+".png");
//
//        MongoCursor<GridFSFile> fileList = gridFS.find(document).iterator();
//
//        while (fileList.hasNext()){
//            GridFSFile gridFSFile = fileList.next();
//            if (null != gridFSFile){
//                try {
//                    gridFS.downloadToStream(gridFSFile.getObjectId(),new FileOutputStream(file));
//                } catch (FileNotFoundException e) {
//                    logger.error(e.getMessage());
//                }
//            }
//        }
//
//        return true;
//    }

    private static String encodeByMD5(final String originString) {
        if (originString != null) {
            try {
                final MessageDigest md = MessageDigest.getInstance("MD5");

                final byte[] results = md.digest(originString.getBytes());

                final String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (final Exception ex) {
                logger.error(ex.getMessage());
                logger.error(ex.getStackTrace());
            }
        }
        return null;
    }

    private static String byteArrayToHexString(final byte[] b) {
        final StringBuffer resultSb = new StringBuffer();
        for (final byte element : b) {
            resultSb.append(byteToHexString(element));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(final byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        final int d1 = n / 16;
        final int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    @PostConstruct
    public void iniAdmin() {
//        Criteria criteria = getCriteria().and("orkID").is("admin");
//        Account account = findOne(criteria);
//        if (null == account) {
//            addAdmin();
////            addChairman(); //主任
////            addMazuiDoctor1();
////            addMazuiDoctor2();
////            addMazuiDoctor3();
////            addMazuiDoctor4();
//        }
    }

    public void addChairman() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("chairman");
        account.setRole("主任");
        account.setTitle("高级主任");
        account.setTrueName("黄天隆");
        account.setSchoolLevel("博士");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("123")); // 密文
        account.setGender("男");
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("chairman");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);
    }

    private void addAdmin() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("admin");
        account.setRole("管理员");
        account.setTitle("工程师");
        account.setTrueName("卓成");
        account.setSchoolLevel("本科");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("1")); // 密文
        account.setGender(Constants.MALE);
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("admin");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);

        //GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
        //gridFS.uploadFromStream( USER_PIC_PREFIX + account.getId()+".png",MyImageCache.class.getResourceAsStream("demoUser/" + "203.png"));
    }

    private void addMazuiDoctor1() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("mazui1");
        account.setRole("麻醉医生");
        account.setTitle("资深医生");
        account.setTrueName("吴医生");
        account.setSchoolLevel("研究生");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("123")); // 密文
        account.setGender("男");
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("mazui1");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);

        //GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
        //gridFS.uploadFromStream( USER_PIC_PREFIX + account.getId()+".png",MyImageCache.class.getResourceAsStream("demoUser/" + "207.png"));
    }

    private void addMazuiDoctor2() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("mazui2");
        account.setRole("麻醉医生");
        account.setTitle("资深医生");
        account.setTrueName("赵明廷");
        account.setSchoolLevel("研究生");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("123")); // 密文
        account.setGender("男");
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("mazui2");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);

        //GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
        //gridFS.uploadFromStream( USER_PIC_PREFIX + account.getId()+".png",MyImageCache.class.getResourceAsStream("demoUser/" + "202.png"));
    }

    private void addMazuiDoctor3() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("mazui3");
        account.setRole("麻醉医生");
        account.setTitle("资深医生");
        account.setTrueName("钱忠敏");
        account.setSchoolLevel("研究生");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("123")); // 密文
        account.setGender("男");
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("mazui3");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);

        //GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
        //gridFS.uploadFromStream( USER_PIC_PREFIX + account.getId()+".png",MyImageCache.class.getResourceAsStream("demoUser/" + "205.png"));
    }

    private void addMazuiDoctor4() {
        Account account = new Account();
        account.setInDate(new Date());
        account.setLoginName("mazui4");
        account.setRole("麻醉医生");
        account.setTitle("资深医生");
        account.setTrueName("杨国标");
        account.setSchoolLevel("研究生");
        account.setLastUpdateTime(new Date());
        account.setPwd(encodeByMD5("123")); // 密文
        account.setGender("男");
        account.setOfficeID("1");
        account.setOfficeName("麻醉科");
        account.setDob(new Date());
        account.setWorkID("mazui4");
        account.setStatus("valid");
        account.setCreateTime(new Date());
        save(account);

        // GridFSBucket gridFS = GridFSBuckets.create(getDb(), "pic");
        //gridFS.uploadFromStream( USER_PIC_PREFIX + account.getId()+".png",MyImageCache.class.getResourceAsStream("demoUser/" + "204.png"));
    }
}