package cn.medigical.publish.dao.impl;

import cn.medigical.publish.utils.SpringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyObservable;

import java.util.*;

/**
 * Created by 2009/4/11. 当前用户缓存
 */
@Component
public class AccountCache {
	AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
	Logger logger = null;
	private static AccountCache ourInstance = new AccountCache();
	Map<String, Account> mapId2Account = new HashMap<>();
	Map<String, Account> mapName2Account = new HashMap<>();
	Account account = null;

	public static AccountCache getInstance() {
		return ourInstance;
	}

	private AccountCache() {
		logger = Logger.getLogger("AccountCache");
	}

	private MyObservable observable = new MyObservable();

	public void addListener(Observer observer) {
		this.observable.addObserver(observer);
	}

	public Account getCurAccount() {
		return account;
	}

	public void setCurAccount(Account account) {
		this.account = account;
		if (!mapId2Account.containsKey(account.getId())) {
			mapId2Account.put(account.getId(), account);
		}
		observable.setChanged();
		observable.notifyObservers(account);
	}

	public void updateAccount(String accountID, String title) {
		Account account = getAccount8Id(accountID);
		account.setTitle(title);
		accountDao.addUpdate(account);
	}

	public Account getAccount8Id(String id) {
		try {
			if (!mapId2Account.containsKey(id)) {
                Account ret = accountDao.findById(id);
                if (null != ret) {
                    mapId2Account.put(id, ret);
                } else {
                    mapId2Account.put(id, new Account());
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mapId2Account.get(id);
	}

	public List<Account> getOperDocs() {
		List<Account> all = accountDao.gets();
		if (null == all || all.size() == 0) {
			return all;
		}

		mapId2Account.clear();
		mapName2Account.clear();
		List<Account> operDocs = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			Account account = all.get(i);
			String role = account.getRole();
			if ("医生".equalsIgnoreCase(role) || "手术医生".equalsIgnoreCase(role)) {
				operDocs.add(account);
			}
			mapId2Account.put(account.getId(), account);
			mapName2Account.put(account.getTrueName(), account);
		}

		return operDocs;
	}

	public List<Account> getNurses() {
		List<Account> all = accountDao.gets();
		if (null == all || all.size() == 0) {
			return all;
		}

		mapId2Account.clear();
		mapName2Account.clear();
		List<Account> nurses = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			Account account = all.get(i);
			String role = account.getRole();

			if (Constants.HUSHI.equalsIgnoreCase(role)) {
				nurses.add(account);
			}
			mapId2Account.put(account.getId(), account);
			mapName2Account.put(account.getTrueName(), account);
		}

		return nurses;
	}

	public List<Account> getMazuiKeShiNurses() {
		List<Account> all = accountDao.gets();
		if (null == all || all.size() == 0) {
			return all;
		}

		mapId2Account.clear();
		List<Account> nurses = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			Account account = all.get(i);
			String role = account.getRole();
			String deptName = account.getOfficeName();
			if (("麻醉科".equals(deptName) || "手术室".equals(deptName)) && Constants.HUSHI.equalsIgnoreCase(role)) {
				nurses.add(account);
			}
			mapId2Account.put(account.getId(), account);
		}

		return nurses;
	}

	public List<Account> getMazuiDocs() {
		List<Account> all = accountDao.findAccountIn();
		if (null == all || all.size() == 0) {
			return all;
		}

		mapId2Account.clear();
		mapName2Account.clear();
		List<Account> mazuiDocs = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			Account account = all.get(i);
			String role = account.getRole();
			if ("麻醉医生".equalsIgnoreCase(role) || "麻醉主任".equalsIgnoreCase(role)) {
				mazuiDocs.add(account);
			}
			mapId2Account.put(account.getId(), account);
			mapName2Account.put(account.getTrueName(), account);
		}

		return mazuiDocs;
	}

	public List<Account> getMazuiKeShiDocs() {
		List<Account> all = accountDao.findAccountIn();
		if (null == all || all.size() == 0) {
			return all;
		}

		mapId2Account.clear();
		List<Account> mazuiDocs = new ArrayList<>();
		for (int i = 0; i < all.size(); i++) {
			Account account = all.get(i);
			String role = account.getRole();
			String deptName = account.getOfficeName();
			if (("麻醉科".equals(deptName) || "手术室".equals(deptName)) && "麻醉医生".equalsIgnoreCase(role) || "麻醉主任".equalsIgnoreCase(role)) {
				mazuiDocs.add(account);
			}
			mapId2Account.put(account.getId(), account);
		}

		return mazuiDocs;
	}

	public List<Account> gets() {
		List<Account> list_account;

		list_account = accountDao.gets();
		if (list_account != null && list_account.size() > 0) {
			mapId2Account.clear();
			mapName2Account.clear();
			for (int i = 0; i < list_account.size(); i++) {
				Account account = list_account.get(i);
				mapId2Account.put(account.getId(), account);
				mapName2Account.put(account.getTrueName(), account);
			}
		}

		return list_account;
	}

	public List<Account> getByOfficeID(String officeID) {
		List<Account> ret = new ArrayList<>();
		List<Account> list_account = new ArrayList<>();
		list_account.addAll(accountDao.gets());

		if (list_account != null && list_account.size() > 0) {
			mapId2Account.clear();
			for (int i = 0; i < list_account.size(); i++) {
				Account account = list_account.get(i);
				mapId2Account.put(account.getId(), account);
			}
		}

		if (list_account.size() > 0) {
			for (int i = 0; i < list_account.size(); i++) {
				Account account = list_account.get(i);
				if (officeID.equalsIgnoreCase(account.getOfficeID())) {
					ret.add(account);
				}
			}
		}

		return ret;
	}

	public List<Account> getOthersByOfficeID(String officeID) {
		List<Account> ret = new ArrayList<>();
		List<Account> list_account = new ArrayList<>();
		list_account.addAll(accountDao.gets());

		if (list_account != null && list_account.size() > 0) {
			mapId2Account.clear();
			for (int i = 0; i < list_account.size(); i++) {
				Account account = list_account.get(i);
				mapId2Account.put(account.getId(), account);
			}
		}

		if (list_account.size() > 0) {
			for (int i = 0; i < list_account.size(); i++) {
				Account account = list_account.get(i);
				if (!officeID.equalsIgnoreCase(account.getOfficeID())) {
					ret.add(account);
				}
			}
		}

		return ret;
	}

	public String getAccountNameById(String accountID) {
		if (null == accountID || accountID.trim().length() == 0) {
			return "";
		}

		Account account = getAccount8Id(accountID);
		if (null == account || account.getTrueName() == null) {
			return "";
		}

		return account.getTrueName();
	}

	public String getAccountTitleById(String accountID) {
		if (null == accountID || accountID.trim().length() == 0) {
			return "";
		}

		Account account = getAccount8Id(accountID);
		if (null == account || account.getTrueName() == null) {
			return "";
		}

		return account.getTitle();
	}

	public String getAccountIdByName(String name) {
		if (null == name || name.equals("")) {
			return null;
		}
		Account account = mapName2Account.get(name);
		if (null == account)
			return null;

		return account.getId();
	}

	public String getAccountTitleByName(String name) {
		if (null == name || name.equals("")) {
			return null;
		}
		Account account = mapName2Account.get(name);
		if (null == account)
			return null;

		return account.getTitle();
	}

	public void setAccountToMap(Account account) {
		if (!this.mapId2Account.containsKey(account.getId())) {
			this.mapId2Account.put(account.getId(), account);
			this.mapName2Account.put(account.getTrueName(), account);
		}
	}
}
