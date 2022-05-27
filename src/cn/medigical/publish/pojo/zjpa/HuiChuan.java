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
                                "            <!--����ҽ������ -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "               <!--������ɫ���� -->  \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--����ҽ������-->  \n" +
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
                                "            <!--Ѳ�ػ�ʿ���� -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--Ѳ�ػ�ʿ����-->  \n" +
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
                                "            <!--��е��ʿ���� -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"%s\"/> \n" +
                                "            </code>  \n" +
                                "            <!--��е��ʿ����-->  \n" +
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
                                "  <!-- ��Ϣ��ˮ�� -->  \n" +
                                "  <id extension=\"" + MsgHelper.getUUID() + "\" root=\"2.16.156.10011.0\"/>  \n" +
                                "  <!-- ��Ϣ����ʱ�� -->  \n" +
                                "  <creationTime value=\"%s\"/>  \n" +
                                "  <!-- ��Ϣ�ķ����ʶ-->  \n" +
                                "  <interactionId extension=\"S0077\" root=\"2.16.840.1.113883.1.6\"/>  \n" +
                                "  <!--������룬��ʶ����Ϣ�Ƿ��ǲ�Ʒ��ѵ��������ϵͳ��һ���֡� D�����ԣ� P����Ʒ�� T��ѵ�� -->  \n" +
                                "  <processingCode code=\"P\"/>  \n" +
                                "  <!-- ��Ϣ����ģʽ: A(Archive); I(Initial load); R(Restore from archive); T(Currentprocessing) -->  \n" +
                                "  <processingModeCode/>  \n" +
                                "  <!-- ��ϢӦ��: AL(Always); ER(Error/reject only); NE(Never) -->  \n" +
                                "  <acceptAckCode code=\"AL\"/>  \n" +
                                "  <!-- ������ -->  \n" +
                                "  <receiver typeCode=\"RCV\"> \n" +
                                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                                "      <!-- ������ ID -->  \n" +
                                "      <id> \n" +
                                "        <item extension=\"SYS001\" root=\"2.16.156.10011.0.1.1\"/> \n" +
                                "      </id> \n" +
                                "    </device> \n" +
                                "  </receiver>  \n" +
                                "  <!-- ������ -->  \n" +
                                "  <sender typeCode=\"SND\"> \n" +
                                "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                                "      <!-- ������ ID -->  \n" +
                                "      <id> \n" +
                                "        <item extension=\"SYS007\" root=\"2.16.156.10011.0.1.2\"/> \n" +
                                "      </id> \n" +
                                "    </device> \n" +
                                "  </sender>  \n" +
                                "  <!-- ��װ����Ϣ����(�� Excel ��д) -->  \n" +
                                "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\"> \n" +
                                "    <!--�����¼� -->  \n" +
                                "    <code code=\"PRSC_TE010100UV01\"/>  \n" +
                                "    <subject typeCode=\"SUBJ\" xsi:nil=\"false\"> \n" +
                                "      <actAppointment classCode=\"ACT\" moodCode=\"APT \" xsi:nil=\"false\"> \n" +
                                "        <!-- �����Ű�� -->  \n" +
                                "        <id extension=\"%s\"/>  \n" +
                                "        <effectiveTime xsi:type=\"IVL_TS\"> \n" +
                                "          <originalText value=\"am\" xsi:type=\"ED\"/>  \n" +
                                "          <!-- ԤԼ����ʱ�� -->  \n" +
                                "          <low value=\"%s\"/>  \n" +
                                "          <!-- Ԥ������ʱ�� -->  \n" +
                                "          <width unit=\"��\" value=\"60\" xsi:type=\"PQ\"/> \n" +
                                "        </effectiveTime>  \n" +
                                "        <!--������Ϣ -->  \n" +
                                "        <subject typeCode=\"SBJ\"> \n" +
                                "          <patient classCode=\"PAT\"> \n" +
                                "            <!--���� ID -->  \n" +
                                "            <id> \n" +
                                "              <!--�ţ�������ű�ʶ -->  \n" +
                                "              <item extension=\"E10000000\" root=\"2.16.156.10011.1.11\"/>  \n" +
                                "              <!--סԺ�ű�ʶ-->  \n" +
                                "              <item extension=\"HA201102113366666\" root=\"2.16.156.10011.1.12\"/>  \n" +
                                "              <!--���� ID ��ʶ-->  \n" +
                                "              <item extension=\"HA201102113366666\" root=\"2.16.156.10011.0.2.2\"/>  \n" +
                                "              <!-- ������� -->  \n" +
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
                                "        <!--ԤԼ�豸 -->  \n" +
                                "        <reusableDevice typeCode=\"RDV\" xsi:nil=\"false\"> \n" +
                                "          <manufacturedDevice classCode=\"MANU \"> \n" +
                                "            <manufacturedDevice classCode=\"DEV \" determinerCode=\"INSTANCE \"> \n" +
                                "              <!-- ԤԼ�豸���� -->  \n" +
                                "              <id extension=\"0001\"/>  \n" +
                                "              <!-- ԤԼ�豸���� -->  \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"���䵥���Ӽ�����ϲ�ɨ����\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </manufacturedDevice> \n" +
                                "          </manufacturedDevice> \n" +
                                "        </reusableDevice>  \n" +
                                "%s" +
                                "        <!--�����ж����������-->  \n" +
                                "        <performer typeCode=\"PRF \" xsi:nil=\"false \"> \n" +
                                "          <assignedPerson classCode=\"ASSIGNED\"> \n" +
                                "            <!--�������ֱ��� -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                                "            </id>  \n" +
                                "            <code> \n" +
                                "              <displayName value=\"��������\"/> \n" +
                                "            </code>  \n" +
                                "            <!--������������-->  \n" +
                                "            <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <part value=\"%s\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </assignedPerson> \n" +
                                "          </assignedPerson> \n" +
                                "        </performer>  \n" +
                                "        <!--ִ�п��� -->  \n" +
                                "        <location typeCode=\"LOC \" xsi:nil=\"false\"> \n" +
                                "          <serviceDeliveryLocation classCode=\"SDLOC \"> \n" +
                                "            <!--ִ�п��ұ��� -->  \n" +
                                "            <id> \n" +
                                "              <item extension=\"%s\" root=\"2.16.156.10011.1.26\"/> \n" +
                                "            </id>  \n" +
                                "            <!--ִ�п������� -->  \n" +
                                "            <addr xsi:type=\"BAG_AD\"> \n" +
                                "              <item> \n" +
                                "                <part value=\"%s\"/> \n" +
                                "              </item> \n" +
                                "            </addr>  \n" +
                                "            <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                                "              <name xsi:type=\"BAG_EN\"> \n" +
                                "                <item> \n" +
                                "                  <!--������-->  \n" +
                                "                  <part times=\"%s\" value=\"%s��������\"/> \n" +
                                "                </item> \n" +
                                "              </name> \n" +
                                "            </location> \n" +
                                "          </serviceDeliveryLocation> \n" +
                                "        </location>  \n" +
                                "        <!--�������뵥��� -->  \n" +
                                "        <referencedOrder typeCode=\"OREF\" xsi:nil=\"false\"> \n" +
                                "          <actOrder classCode=\"ACT\" moodCode=\"RQO\"> \n" +
                                "            <!--�������뵥�� -->  \n" +
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
                        "  <!-- ��Ϣ��ˮ�� -->  \n" +
                        "  <id extension=\"" + MsgHelper.getUUID() + "\" root=\"2.16.156.10011.0\"/>  \n" +
                        "  <!-- ��Ϣ����ʱ�� -->  \n" +
                        "  <creationTime value=\"%s\"/>  \n" +
                        "  <!-- ��Ϣ�ķ����ʶ-->  \n" +
                        "  <interactionId extension=\"S0080\" root=\"2.16.840.1.113883.1.6\"/>  \n" +
                        "  <!--������룬��ʶ����Ϣ�Ƿ��ǲ�Ʒ��ѵ��������ϵͳ��һ���֡� D�����ԣ� P����Ʒ�� T��ѵ�� -->  \n" +
                        "  <processingCode code=\"P\"/>  \n" +
                        "  <!-- ��Ϣ����ģʽ: A(Archive); I(Initial load); R(Restore from archive); T(Currentprocessing) -->  \n" +
                        "  <processingModeCode/>  \n" +
                        "  <!-- ��ϢӦ��: AL(Always); ER(Error/reject only); NE(Never) -->  \n" +
                        "  <acceptAckCode code=\"AL\"/>  \n" +
                        "  <!-- ������ -->  \n" +
                        "  <receiver typeCode=\"RCV\"> \n" +
                        "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                        "      <!-- ������ID -->  \n" +
                        "      <id> \n" +
                        "        <item extension=\"SYS001\" root=\"2.16.156.10011.0.1.1\"/> \n" +
                        "      </id> \n" +
                        "    </device> \n" +
                        "  </receiver>  \n" +
                        "  <!-- ������ -->  \n" +
                        "  <sender typeCode=\"SND\"> \n" +
                        "    <device classCode=\"DEV\" determinerCode=\"INSTANCE\"> \n" +
                        "      <!-- ������ID -->  \n" +
                        "      <id> \n" +
                        "        <item extension=\"SYS007\" root=\"2.16.156.10011.0.1.2\"/> \n" +
                        "      </id> \n" +
                        "    </device> \n" +
                        "  </sender>  \n" +
                        "  <!-- ��װ����Ϣ����(��Excel��д) -->  \n" +
                        "  <controlActProcess classCode=\"CACT\" moodCode=\"EVN\"> \n" +
                        "    <!-- ��Ϣ�������� @code: ���� :new �޸�:update -->  \n" +
                        "    <code code=\"POOR_TE200902UV\" codeSystem=\"2.16.840.1.113883.1.6\"/>  \n" +
                        "    <subject typeCode=\"SUBJ\" xsi:nil=\"false\"> \n" +
                        "      <placerGroup> \n" +
                        "        <!-- 1..n��ѭ�� ���״̬��Ϣ -->  \n" +
                        "        <component2> \n" +
                        "          <procedureRequest classCode=\"PROC\"> \n" +
                        "            <!-- ��������ʹ�� -->  \n" +
                        "            <id> \n" +
                        "              <!-- ���뵥�� -->  \n" +
                        "              <item extension=\"%s\" root=\"2.16.156.10011.1.24\"/> \n" +
                        "            </id>  \n" +
                        "            <!-- ������δʹ�� -->  \n" +
                        "            <code/>  \n" +
                        "            <!-- ������δʹ�� -->  \n" +
                        "            <statusCode/>  \n" +
                        "            <!-- ������δʹ�� -->  \n" +
                        "            <effectiveTime xsi:type=\"IVL_TS\"/>  \n" +
                        "            <!-- ������ -->  \n" +
                        "            <performer typeCode=\"PRF\"> \n" +
                        "              <time> \n" +
                        "                <!-- �������� -->  \n" +
                        "                <low value=\"%s\"/> \n" +
                        "              </time>  \n" +
                        "              <assignedEntity classCode=\"ASSIGNED\"> \n" +
                        "                <!-- �����˱��� -->  \n" +
                        "                <id> \n" +
                        "                  <item extension=\"%s\" root=\"2.16.156.10011.1.4\"/> \n" +
                        "                </id>  \n" +
                        "                <assignedPerson classCode=\"PSN\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!-- ���������� ��������ʹ�� -->  \n" +
                        "                  <name>%s</name> \n" +
                        "                </assignedPerson> \n" +
                        "              </assignedEntity> \n" +
                        "            </performer>  \n" +
                        "            <!--ִ�п��� -->  \n" +
                        "            <location typeCode=\"LOC\" xsi:nil=\"false\"> \n" +
                        "              <!--������δʹ�� -->  \n" +
                        "              <time/>  \n" +
                        "              <!--�������/���� -->  \n" +
                        "              <serviceDeliveryLocation classCode=\"SDLOC\"> \n" +
                        "                <serviceProviderOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--ִ�п��ұ��� -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"%s\" root=\"2.16.156.10011.1.26\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!--ִ�п������� -->  \n" +
                        "                  <name>%s</name> \n" +
                        "                </serviceProviderOrganization> \n" +
                        "              </serviceDeliveryLocation> \n" +
                        "            </location>  \n" +
                        "            <!-- ����״̬ -->  \n" +
                        "            <component1 contextConductionInd=\"true\"> \n" +
                        "              <processStep classCode=\"PROC\"> \n" +
                        "                <code code=\"%s\" codeSystem=\"1.2.156.112635.1.1.93\"> \n" +
                        "                  <!--����״̬���� -->  \n" +
                        "                  <displayName value=\"\"/> \n" +
                        "                </code> \n" +
                        "              </processStep> \n" +
                        "            </component1> \n" +
                        "					<!--������ʼ������ʱ�� -->\n" +
                        "					<effectiveTime xsi:type=\"IVL_TS\">\n" +
                        "							<!--��ʼʱ��-->\n" +
                        "								<low value=\"%s\"/>\n" +
                        "							<!--����ʱ��-->\n" +
                        "								<high value=\"%s\"/>\n" +
                        "					</effectiveTime>\n" +
                        "          </procedureRequest> \n" +
                        "        </component2>  \n" +
                        "        <!--���� -->  \n" +
                        "        <componentOf1 contextConductionInd=\"false\" typeCode=\"COMP\" xsi:nil=\"false\"> \n" +
                        "          <!--���� -->  \n" +
                        "          <encounter classCode=\"ENC\" moodCode=\"EVN\"> \n" +
                        "            <id> \n" +
                        "              <!-- ������� ��������ʹ�� -->  \n" +
                        "              <item extension=\" \" root=\"1.2.156.112635.1.2.1.7\"/>  \n" +
                        "              <!-- ������ˮ�� -->  \n" +
                        "              <item extension=\" \" root=\"1.2.156.112635.1.2.1.6\"/> \n" +
                        "            </id>  \n" +
                        "            <!--����������-->  \n" +
                        "            <code code=\"01\" codeSystem=\"2.16.156.10011.2.3.1.271\"> \n" +
                        "              <!-- ����������� -->  \n" +
                        "              <displayName value=\"����/סԺ/���\"/> \n" +
                        "            </code>  \n" +
                        "            <!--������δʹ�� -->  \n" +
                        "            <statusCode code=\"Active\"/>  \n" +
                        "            <!--���� ������δʹ�� -->  \n" +
                        "            <subject typeCode=\"SBJ\"> \n" +
                        "              <patient classCode=\"PAT\"> \n" +
                        "                <id> \n" +
                        "                  <!--��ID -->  \n" +
                        "                  <item extension=\" \" root=\"1.2.156.112635.1.2.1.2\"/>  \n" +
                        "                  <!-- ����ID -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.0.2.2\"/>  \n" +
                        "                  <!-- ����� -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.1.11\"/>  \n" +
                        "                  <!-- סԺ�� -->  \n" +
                        "                  <item extension=\" \" root=\"2.16.156.10011.1.12\"/> \n" +
                        "                </id>  \n" +
                        "                <patientPerson classCode=\"PSN\" determinerCode=\"INSTANCE\" xsi:nil=\"false\"> \n" +
                        "                  <!-- �������� -->  \n" +
                        "                  <name> </name> \n" +
                        "                </patientPerson> \n" +
                        "              </patient> \n" +
                        "            </subject>  \n" +
                        "            <!--סԺλ��-->  \n" +
                        "            <location typeCode=\"LOC\"> \n" +
                        "              <time/>  \n" +
                        "              <serviceDeliveryLocation classCode=\"SDLOC\"> \n" +
                        "                <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--DE01.00.026.00 �������� -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!-- ������ -->  \n" +
                        "                  <name></name>  \n" +
                        "                  <asLocatedEntityPartOf classCode=\"LOCE\"> \n" +
                        "                    <location classCode=\"PLC\" determinerCode=\"INSTANCE\"> \n" +
                        "                      <!--DE01.00.019.00 �������� -->  \n" +
                        "                      <id> \n" +
                        "                        <item extension=\"\"/> \n" +
                        "                      </id>  \n" +
                        "                      <!-- ������ -->  \n" +
                        "                      <name></name> \n" +
                        "                    </location> \n" +
                        "                  </asLocatedEntityPartOf> \n" +
                        "                </location>  \n" +
                        "                <serviceProviderOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                  <!--DE08.10.026.00 ���ұ��� -->  \n" +
                        "                  <id> \n" +
                        "                    <item extension=\"\"/> \n" +
                        "                  </id>  \n" +
                        "                  <!-- �������� -->  \n" +
                        "                  <name>�����ڿ�</name>  \n" +
                        "                  <asOrganizationPartOf classCode=\"PART\"> \n" +
                        "                    <!-- DE08.10.054.00 �������� -->  \n" +
                        "                    <wholeOrganization classCode=\"ORG\" determinerCode=\"INSTANCE\"> \n" +
                        "                      <id> \n" +
                        "                        <item extension=\"\"/> \n" +
                        "                      </id>  \n" +
                        "                      <!-- �������� -->  \n" +
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