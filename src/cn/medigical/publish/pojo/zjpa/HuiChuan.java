package cn.medigical.publish.pojo.zjpa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.udp.MsgHelper;
import cn.medigical.publish.utils.MyConstants;
import cn.medigical.publish.utils.SpringUtils;



public class HuiChuan {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
    static Map<String,Integer > statusMap=new HashMap();
    static {
        statusMap.clear();
        statusMap.put(MyConstants.OR_STATUS_FLAG_APPLIED,2);
        statusMap.put(MyConstants.OR_STATUS_FLAG_SCHEDULED,3);
        statusMap.put(MyConstants.OR_STATUS_FLAG_IN_ROOM,5);
        statusMap.put(MyConstants.OR_STATUS_FLAG_OUT_ROOM,6);
        statusMap.put(MyConstants.OR_STATUS_FLAG_CANCEL,7);
        statusMap.put(MyConstants.OR_STATUS_FLAG_UNKNOWN,8);
    }


    public String getSurgeryScheduleXML(PatientLink operSchedule) {
        String xml = "";
        try {

            if (operSchedule == null) {
                operSchedule = new PatientLink();
            } else {
                if (operSchedule.getSchedule().getJhsssj() == null)
                    operSchedule.getSchedule().setJhsssj(new Date());
                if (operSchedule.getSchedule().getPbssjh() == null)
                    operSchedule.getSchedule().setPbssjh("");

                Account common = accountDao.findAccountById(operSchedule.getSchedule().getMzysbh1());
                String mazuiDocCode = "";
                String operationRole = "";
                String maZuiDocName = "";
                if (common != null) {
                    mazuiDocCode = accountDao.findAccountById(operSchedule.getSchedule().getMzysbh1()).getWorkID();
                    operationRole = common.getTitle();
                    maZuiDocName = common.getTrueName();
                }
                String mzys = String.format("<performer typeCode=\"PRF \" xsi:nil=\"false \"> \n" +
                                "          <assignedPerson classCode=\"maZuiDoc\"> \n" +
                                "            <!--麻醉医生编码 -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "               <!--手术角色编码 -->  \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--麻醉医生姓名-->  \n" +
                                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"%s\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </assignedPerson> \n" +
                                "          </assignedPerson> \n" +
                                "        </performer>  \n",
                        trimStr(mazuiDocCode), trimStr(operationRole),trimStr(maZuiDocName));
                common = accountDao.findAccountById(operSchedule.getSchedule().getXhhsbh1());
                String schulTile = "";
                String schulTruName = "";
                String schulNurse = "";
                if (common != null) {
                    schulNurse = common.getWorkID();
                    schulTile = common.getTitle();
                    schulTruName = common.getTrueName();
                }
                String xhhs = String.format("<performer typeCode=\"PRF \" xsi:nil=\"false \"> \n" +
                                "          <assignedPerson classCode=\"circuitNurse\"> \n" +
                                "            <!--巡回护士编码 -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--巡回护士姓名-->  \n" +
                                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"%s\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </assignedPerson> \n" +
                                "          </assignedPerson> \n" +
                                "        </performer>  \n",
                        trimStr(schulNurse), trimStr(schulTile), trimStr(schulTruName));
                common = accountDao.findAccountById(operSchedule.getSchedule().getQxhsbh1());
                String qxhs1 = "";
                String qxhsTile = "";
                String qxhsName = "";
                if (common != null) {
                    qxhs1 = accountDao.findAccountById(operSchedule.getSchedule().getQxhsbh1()).getWorkID();
                    qxhsTile = common.getTitle();
                    qxhsName = common.getTrueName();
                }
                String qxhs = String.format("<performer typeCode=\"PRF \" xsi:nil=\"false \"> \n" +
                                "          <assignedPerson classCode=\"mechaNurse\"> \n" +
                                "            <!--器械护士编码 -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--器械护士姓名-->  \n" +
                                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"%s\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </assignedPerson> \n" +
                                "          </assignedPerson> \n" +
                                "        </performer>  \n",
                        trimStr(qxhs1), trimStr(qxhsTile), trimStr(qxhsName));
                String temp = mzys + xhhs + qxhs;
                xml = String.format("<PRSC_IN010101UV01 xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">  \n" +
                                "  <!-- 消息流水号 -->  \n" +
                                "  <id extension=\"" + MsgHelper.getUUID() + "\" root=\"2.16.156.10011.0\"/>  \n" +
                                "  <!-- 消息创建时间 -->  \n" +
                                "  <creationTime value=\"%s\"/>  \n" +
                                "  <!-- 消息的服务标识-->  \n" +
                                "  <interactionId extension=\"S0077\" root=\"2.16.840.1.113883.1.6\"/>  \n" +
                                "  <!--处理代码，标识此消息是否是产品、训练、调试系统的一部分。 D：调试； P：产品； T：训练 -->  \n" +
                                "  <processingCode code=\"P\"/>  \n" +
                                "  <!-- 消息处理模式: A(Archive); I(Initial load); R(Restore from archive); T(Currentprocessing) -->  \n" +
                                "  <processingModeCode/>  \n" +
                                "  <!-- 消息应答: AL(Always); ER(Error/reject only); NE(Never) -->  \n" +
                                "  <acceptAckCode code=\"AL\"/>  \n" +
                                "  <!-- 接受者 -->  \n" +
                                "  <receiver typeCode=\"RCV\"> \n" +
                                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                                "      <!-- 接受者 ID -->  \n" +
                                "      <id> \n" +
                                "        <item extension=\"SYS001\" root=\"2.16.156.10011.0.1.1\"/> \n" +
                                "      </id> \n" +
                                "    </device> \n" +
                                "  </receiver>  \n" +
                                "  <!-- 发送者 -->  \n" +
                                "  <sender typeCode=\"SND\"> \n" +
                                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                                "      <!-- 发送者 ID -->  \n" +
                                "      <id> \n" +
                                "        <item extension=\"SYS007\" root=\"2.16.156.10011.0.1.2\"/> \n" +
                                "      </id> \n" +
                                "    </device> \n" +
                                "  </sender>  \n" +
                                "  <!-- 封装的消息内容(按 Excel 填写) -->  \n" +
                                "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\"> \n" +
                                "    <!--触发事件 -->  \n" +
                                "    <code code=\"PRSC_TE010100UV01\"/>  \n" +
                                "    <subject typeCode=\"SUBJ\" xsi:nil=\"false\"> \n" +
                                "      <actAppointment classCode=\"ACT\" moodCode=\"APT \" xsi:nil=\"false\"> \n" +
                                "        <!-- 手术排班号 -->  \n" +
                                "        <id extension=\"%s\"/>  \n" +
                                "        <effectiveTime xsi:type=\"IVL_TS\"> \n" +
                                "          <originalText value=\"am\" xsi:type=\"ED\"/>  \n" +
                                "          <!-- 预约手术时间 -->  \n" +
                                "          <low value=\"%s\"/>  \n" +
                                "          <!-- 预计手术时长 -->  \n" +
                                "          <width unit=\"分\" value=\"60\" xsi:type=\"PQ\"/> \n" +
                                "        </effectiveTime>  \n" +
                                "        <!--患者信息 -->  \n" +
                                "        <subject typeCode=\"SBJ\"> \n" +
                                "          <patient classCode=\"PAT\"> \n" +
                                "            <!--患者 ID -->  \n" +
                                "            <id> \n" +
                                "              <!--门（急）诊号标识 -->  \n" +
                                "              <item extension=\"E10000000\" root=\"2.16.156.10011.1.11\"/>  \n" +
                                "              <!--住院号标识-->  \n" +
                                "              <item extension=\"HA201102113366666\" root=\"2.16.156.10011.1.12\"/>  \n" +
                                "              <!--患者 ID 标识-->  \n" +
                                "              <item extension=\"HA201102113366666\" root=\"2.16.156.10011.0.2.2\"/>  \n" +
                                "              <!-- 就诊次数 -->  \n" +
                                "              <item extension=\"12\" root=\"1.2.156.112606.1.2.1.7\"/> \n" +
                                "            </id>  \n" +
                                "            <patientPerson> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </patientPerson> \n" +
                                "          </patient> \n" +
                                "        </subject>  \n" +
                                "        <!--预约设备 -->  \n" +
                                "        <reusableDevice typeCode=\"RDV\" xsi:nil=\"false\"> \n" +
                                "          <manufacturedDevice classCode=\"MANU \"> \n" +
                                "            <manufacturedDevice classCode=\"DEV \" determinerCode=\"INSTANCE \"> \n" +
                                "              <!-- 预约设备编码 -->  \n" +
                                "              <id extension=\"0001\"/>  \n" +
                                "              <!-- 预约设备名称 -->  \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"发射单光子计算机断层扫描仪\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </manufacturedDevice> \n" +
                                "          </manufacturedDevice> \n" +
                                "        </reusableDevice>  \n" +
                                "%s" +
                                "        <!--可以有多个手术助手-->  \n" +
                                "        <performer typeCode=\"PRF \" xsi:nil=\"false \"> \n" +
                                "          <assignedPerson classCode=\"ASSIGNED\"> \n" +
                                "            <!--手术助手编码 -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"手术助手\"/> \n" +
                                "            </code>  \n" +
                                "            <!--手术助手姓名-->  \n" +
                                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"%s\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </assignedPerson> \n" +
                                "          </assignedPerson> \n" +
                                "        </performer>  \n" +
                                "        <!--执行科室 -->  \n" +
                                "        <location typeCode=\"LOC \" xsi:nil=\"false\"> \n" +
                                "          <serviceDeliveryLocation classCode=\"SDLOC \"> \n" +
                                "            <!--执行科室编码 -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.26\"/> \n" +
                                "            </id>  \n" +
                                "            <!--执行科室名称 -->  \n" +
                                "            <addr xsi:type=\"BAG_AD\"> \n" +
                                "              <item> \n" +
                                "                <part value=\"%s\"/> \n" +
                                "              </item> \n" +
                                "            </addr>  \n" +
                                "            <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <!--手术间-->  \n" +
                                "                  <part times=\"%s\" value=\"%s号手术间\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </location> \n" +
                                "          </serviceDeliveryLocation> \n" +
                                "        </location>  \n" +
                                "        <!--手术申请单编号 -->  \n" +
                                "        <referencedOrder typeCode=\"OREF\" xsi:nil=\"false\"> \n" +
                                "          <actOrder classCode=\"ACT\" moodCode=\"RQO\"> \n" +
                                "            <!--手术申请单号 -->  \n" +
                                "            <id extension=\"%s\" root=\"2.16.156.10011.1.24\"/> \n" +
                                "          </actOrder> \n" +
                                "        </referencedOrder> \n" +
                                "      </actAppointment> \n" +
                                "    </subject> \n" +
                                "  </controlActProcess> \n" +
                                "</PRSC_IN010101UV01>\n",
                        new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),
                        operSchedule.getId(),
                        new SimpleDateFormat("yyyyMMddHHmmss").format(operSchedule.getSchedule().getJhsssj()),
                        temp,
                        operSchedule.getReturnStatusMsg().getWorkId(),
                        operSchedule.getReturnStatusMsg().getName(),
                        operSchedule.getPatient().getKsbh(),
                        operSchedule.getPatient().getKsmc(),
                        operSchedule.getSchedule().getPbts(),
                        operSchedule.getSchedule().getPbssjh(),
                        operSchedule.getHisID());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return xml;
    }

    private String getTs(String ts) {
        if (ts != null && !"".equalsIgnoreCase(ts)) {
            return String.valueOf(Integer.parseInt(ts) + 1);
        }
        return "";
    }

    public String getSurgicalState(PatientLink patientLink) {
        String status = String.valueOf(8);
        status = String.valueOf(statusMap.get(patientLink.getApplication().getDetailstatus()));
        if (("invalid").equalsIgnoreCase(patientLink.getPatient().getStatus())) {
            status = "7";
        }
        String inRoomTime="";
        String outRoomTime="";
        if(patientLink.getStatus().getInRoomTime()!=null){
            inRoomTime=new SimpleDateFormat("yyyyMMddHHmm").format(patientLink.getStatus().getInRoomTime());
        }
        if(patientLink.getStatus().getOutRoomTime()!=null){
            outRoomTime= new SimpleDateFormat("yyyyMMddHHmm").format(patientLink.getStatus().getOutRoomTime());
        }
        String xml = String.format("<POOR_IN200902UV xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ITSVersion=\"XML_1.0\">  \n" +
                        "  <!-- 消息流水号 -->  \n" +
                        "  <id extension=\"" + MsgHelper.getUUID() + "\" root=\"2.16.156.10011.0\"/>  \n" +
                        "  <!-- 消息创建时间 -->  \n" +
                        "  <creationTime value=\"%s\"/>  \n" +
                        "  <!-- 消息的服务标识-->  \n" +
                        "  <interactionId extension=\"S0080\" root=\"2.16.840.1.113883.1.6\"/>  \n" +
                        "  <!--处理代码，标识此消息是否是产品、训练、调试系统的一部分。 D：调试； P：产品； T：训练 -->  \n" +
                        "  <processingCode code=\"P\"/>  \n" +
                        "  <!-- 消息处理模式: A(Archive); I(Initial load); R(Restore from archive); T(Currentprocessing) -->  \n" +
                        "  <processingModeCode/>  \n" +
                        "  <!-- 消息应答: AL(Always); ER(Error/reject only); NE(Never) -->  \n" +
                        "  <acceptAckCode code=\"AL\"/>  \n" +
                        "  <!-- 接受者 -->  \n" +
                        "  <receiver typeCode=\"RCV\"> \n" +
                        "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                        "      <!-- 接受者ID -->  \n" +
                        "      <id> \n" +
                        "        <item extension=\"SYS001\" root=\"2.16.156.10011.0.1.1\"/> \n" +
                        "      </id> \n" +
                        "    </device> \n" +
                        "  </receiver>  \n" +
                        "  <!-- 发送者 -->  \n" +
                        "  <sender typeCode=\"SND\"> \n" +
                        "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                        "      <!-- 发送者ID -->  \n" +
                        "      <id> \n" +
                        "        <item extension=\"SYS007\" root=\"2.16.156.10011.0.1.2\"/> \n" +
                        "      </id> \n" +
                        "    </device> \n" +
                        "  </sender>  \n" +
                        "  <!-- 封装的消息内容(按Excel填写) -->  \n" +
                        "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\"> \n" +
                        "    <!-- 消息交互类型 @code: 新增 :new 修改:update -->  \n" +
                        "    <code code=\"POOR_TE200902UV\" codeSystem=\"2.16.840.1.113883.1.6\"/>  \n" +
                        "    <subject typeCode=\"SUBJ\" xsi:nil=\"false\"> \n" +
                        "      <placerGroup> \n" +
                        "        <!-- 1..n可循环 检查状态信息 -->  \n" +
                        "        <component2> \n" +
                        "          <procedureRequest classCode=\"PROC\"> \n" +
                        "            <!-- 必须项已使用 -->  \n" +
                        "            <id> \n" +
                        "              <!-- 申请单号 -->  \n" +
                        "              <item extension=\"%s\" root=\"2.16.156.10011.1.24\"/> \n" +
                        "            </id>  \n" +
                        "            <!-- 必须项未使用 -->  \n" +
                        "            <code/>  \n" +
                        "            <!-- 必须项未使用 -->  \n" +
                        "            <statusCode/>  \n" +
                        "            <!-- 必须项未使用 -->  \n" +
                        "            <effectiveTime xsi:type=\"IVL_TS\"/>  \n" +
                        "            <!-- 操作人 -->  \n" +
                        "            <performer typeCode=\"PRF\"> \n" +
                        "              <time> \n" +
                        "                <!-- 操作日期 -->  \n" +
                        "                <low value=\"%s\"/> \n" +
                        "              </time>  \n" +
                        "              <assignedEntity classCode=\"ASSIGNED\"> \n" +
                        "                <!-- 操作人编码 -->  \n" +
                        "                <id> \n" +
                        "                  <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                        "                </id>  \n" +
                        "                <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!-- 操作人姓名 必须项已使用 -->  \n" +
                        "                  <name>%s</name> \n" +
                        "                </assignedPerson> \n" +
                        "              </assignedEntity> \n" +
                        "            </performer>  \n" +
                        "            <!--执行科室 -->  \n" +
                        "            <location typeCode=\"LOC\" xsi:nil=\"false\"> \n" +
                        "              <!--必须项未使用 -->  \n" +
                        "              <time/>  \n" +
                        "              <!--就诊机构/科室 -->  \n" +
                        "              <serviceDeliveryLocation classCode=\"SDLOC\"> \n" +
                        "                <serviceProviderOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--执行科室编码 -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"%s\" root=\"2.16.156.10011.1.26\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!--执行科室名称 -->  \n" +
                        "                  <name>%s</name> \n" +
                        "                </serviceProviderOrganization> \n" +
                        "              </serviceDeliveryLocation> \n" +
                        "            </location>  \n" +
                        "            <!-- 手术状态 -->  \n" +
                        "            <component1 contextConductionInd=\"true\"> \n" +
                        "              <processStep classCode=\"PROC\"> \n" +
                        "                <code code=\"%s\" codeSystem=\"1.2.156.112635.1.1.93\"> \n" +
                        "                  <!--手术状态名称 -->  \n" +
                        "                  <displayName value=\"\"/> \n" +
                        "                </code> \n" +
                        "              </processStep> \n" +
                        "            </component1> \n" +
                        "					<!--手术开始、结束时间 -->\n" +
                        "					<effectiveTime xsi:type=\"IVL_TS\">\n" +
                        "							<!--开始时间-->\n" +
                        "								<low value=\"%s\"/>\n" +
                        "							<!--结束时间-->\n" +
                        "								<high value=\"%s\"/>\n" +
                        "					</effectiveTime>\n" +
                        "          </procedureRequest> \n" +
                        "        </component2>  \n" +
                        "        <!--就诊 -->  \n" +
                        "        <componentOf1 contextConductionInd=\"false\" typeCode=\"COMP\" xsi:nil=\"false\"> \n" +
                        "          <!--就诊 -->  \n" +
                        "          <encounter classCode=\"ENC\" moodCode=\"EVN\"> \n" +
                        "            <id> \n" +
                        "              <!-- 就诊次数 必须项已使用 -->  \n" +
                        "              <item extension=\" \" root=\"1.2.156.112635.1.2.1.7\"/>  \n" +
                        "              <!-- 就诊流水号 -->  \n" +
                        "              <item extension=\" \" root=\"1.2.156.112635.1.2.1.6\"/> \n" +
                        "            </id>  \n" +
                        "            <!--就诊类别编码-->  \n" +
                        "            <code code=\"01\" codeSystem=\"2.16.156.10011.2.3.1.271\"> \n" +
                        "              <!-- 就诊类别名称 -->  \n" +
                        "              <displayName value=\"门诊/住院/体检\"/> \n" +
                        "            </code>  \n" +
                        "            <!--必须项未使用 -->  \n" +
                        "            <statusCode code=\"Active\"/>  \n" +
                        "            <!--病人 必须项未使用 -->  \n" +
                        "            <subject typeCode=\"SBJ\"> \n" +
                        "              <patient classCode=\"PAT\"> \n" +
                        "                <id> \n" +
                        "                  <!--域ID -->  \n" +
                        "                  <item extension=\" \" root=\"1.2.156.112635.1.2.1.2\"/>  \n" +
                        "                  <!-- 患者ID -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.0.2.2\"/>  \n" +
                        "                  <!-- 门诊号 -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.1.11\"/>  \n" +
                        "                  <!-- 住院号 -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.1.12\"/> \n" +
                        "                </id>  \n" +
                        "                <patientPerson classCode=\"PSN\" determinerCode=\"INSTANCE\" xsi:nil=\"false\"> \n" +
                        "                  <!-- 患者姓名 -->  \n" +
                        "                  <name> </name> \n" +
                        "                </patientPerson> \n" +
                        "              </patient> \n" +
                        "            </subject>  \n" +
                        "            <!--住院位置-->  \n" +
                        "            <location typeCode=\"LOC\"> \n" +
                        "              <time/>  \n" +
                        "              <serviceDeliveryLocation classCode=\"SDLOC\"> \n" +
                        "                <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--DE01.00.026.00 病床编码 -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!-- 病床号 -->  \n" +
                        "                  <name></name>  \n" +
                        "                  <asLocatedEntityPartOf classCode=\"LOCE\"> \n" +
                        "                    <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                        "                      <!--DE01.00.019.00 病房编码 -->  \n" +
                        "                      <id> \n" +
                        "                        <item extension=\"\"/> \n" +
                        "                      </id>  \n" +
                        "                      <!-- 病房号 -->  \n" +
                        "                      <name></name> \n" +
                        "                    </location> \n" +
                        "                  </asLocatedEntityPartOf> \n" +
                        "                </location>  \n" +
                        "                <serviceProviderOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--DE08.10.026.00 科室编码 -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!-- 科室名称 -->  \n" +
                        "                  <name>呼吸内科</name>  \n" +
                        "                  <asOrganizationPartOf classCode=\"PART\"> \n" +
                        "                    <!-- DE08.10.054.00 病区编码 -->  \n" +
                        "                    <wholeOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                      <id> \n" +
                        "                        <item extension=\"\"/> \n" +
                        "                      </id>  \n" +
                        "                      <!-- 病区名称 -->  \n" +
                        "                      <name></name> \n" +
                        "                    </wholeOrganization> \n" +
                        "                  </asOrganizationPartOf> \n" +
                        "                </serviceProviderOrganization> \n" +
                        "              </serviceDeliveryLocation> \n" +
                        "            </location> \n" +
                        "          </encounter> \n" +
                        "        </componentOf1> \n" +
                        "      </placerGroup> \n" +
                        "    </subject> \n" +
                        "  </controlActProcess> \n" +
                        "</POOR_IN200902UV>\n",
                new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()),
                patientLink.getHisID(),
                new SimpleDateFormat("yyyyMMddHHmmss").format(patientLink.getReturnStatusMsg().getReturnTime()),
                patientLink.getReturnStatusMsg().getWorkId(),
                patientLink.getReturnStatusMsg().getName(),
                patientLink.getReturnStatusMsg().getDeptId(),
                patientLink.getReturnStatusMsg().getDeptName(),
                status,
                inRoomTime,
                outRoomTime);
        return xml;
    }

    public boolean notNull(Object object) {
        boolean flag = false;
        if (object != null) {
            flag = true;
        }
        return flag;
    }

    protected static String trimStr(String str) {
        if (null == str)
            return "";
        return str.trim();
    }
}