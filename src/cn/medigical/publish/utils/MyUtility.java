package cn.medigical.publish.utils;

import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by  on 2010/5/20, 7:07.
 * Copy right by
 */
public class MyUtility {
    static Logger logger = Logger.getLogger("MyUtility");

    private MyUtility() {

    }

    public static HashMap<RenderingHints.Key, Object> renderingHints;

    private static final DecimalFormat DECIMAL_FORMAT3 = new DecimalFormat("####.###");
    private static final DecimalFormat DECIMAL_FORMAT2 = new DecimalFormat("####.##");
    private static final DecimalFormat DECIMAL_FORMAT1 = new DecimalFormat("####.#");
    private static final DecimalFormat DECIMAL_FORMAT0 = new DecimalFormat("####");
    private static final String REPLACE_ZERO = ".0";

    static {
        renderingHints = new HashMap();
        renderingHints.put(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        renderingHints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        renderingHints.put(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_DISABLE);
        renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        renderingHints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        renderingHints.put(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        renderingHints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    }

    public static GridBagConstraints setGridBagConstraints(
            GridBagConstraints gbc, int gridx, int gridy, int fill, int anchor, double weightx, double weighty) {
        return setGridBagConstraints(gbc, gridx, gridy, fill, anchor, weightx, weighty, 0, 0, 0, 0);
    }


    public static GridBagConstraints setGridBagConstraints(
            GridBagConstraints gbc, int gridx, int gridy, int fill, int anchor, double weightx, double weighty
            , int gridwidth, int gridheight) {
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        return gbc;
    }

    public static GridBagConstraints setGridBagConstraints(
            GridBagConstraints gbc, int gridx, int gridy, int fill, int anchor, double weightx, double weighty,
            int top, int left, int bottom, int right) {
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = new Insets(top, left, bottom, right);

        return gbc;
    }

    public static GridBagConstraints setGridBagConstraints(
            GridBagConstraints gbc, int gridx, int gridy, int fill, int anchor, double weightx, double weighty,
            int top, int left, int bottom, int right , int gridwidth, int gridheight) {
        gbc.fill = fill;
        gbc.anchor = anchor;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = new Insets(top, left, bottom, right);
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;

        return gbc;
    }

    public static void makeMeCenter(Dimension myBound, Component component) {
        double sw = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        double sh = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        int x = (int) ((sw - myBound.width) / 2);
        int y = (int) ((sh - myBound.height) / 2);
        component.setBounds(x, y, myBound.width, myBound.height);
    }


/*
    public static void setMyFont(Container container) {
        for (int i = 0; i < container.getComponentCount(); i++) {
            Component component = container.getComponent(i);
            if (component instanceof JComboBox ||
                    component instanceof JTextField ||
                    component instanceof JLabel ||
                    component instanceof JButton ||
                    component instanceof JRadioButton ||
                    component instanceof JCheckBox ||
                    component instanceof JTextArea ||
                    component instanceof JTextPane
                    ) {
                component.setFont(MyFont.MY_FONT_PLAIN_15);
            } else if (component instanceof JTable) {
                ((JTable)component).getTableHeader().setFont(MyFont.MY_FONT_PLAIN_15);
                ((JTable)component).setFont(MyFont.MY_FONT_PLAIN_15);
            } else if (component instanceof Container) {
                setMyFont((Container) component);
            }
        }
    }
*/

/*
    public static void setBackgroundColor(Container container){
        if (container instanceof JPanel) {
            container.setBackground(UITheme.colorInterface.getPanelBgColor());
        }
        for (int i=0;i<container.getComponentCount();i++){
            Component component =container.getComponent(i);
            if (component instanceof JPanel) {
                component.setBackground(UITheme.colorInterface.getPanelBgColor());
            }
            if (component instanceof Container){
                setBackgroundColor((Container)component);
            }
        }

    }
*/

    /*public static void setBorder2Null(Container container) {
//        ((JComponent)container).setBorder(null);
        for (int i = 0; i < container.getComponentCount(); i++) {
            Component component = container.getComponent(i);
            if (component instanceof JScrollPane) {
                ((JScrollPane)component).setBorder(null);
                ((JScrollPane)component).setViewportBorder(null);
            }else if (component instanceof Container) {
                setBorder2Null((Container) component);
            }else{
                ((JComponent)component).setBorder(null);
            }
        }
    }*/

    /*public static void setAllFont(Container container,Font font) {
        for (int i = 0; i < container.getComponentCount(); i++) {
            Component component = container.getComponent(i);
            if (component instanceof JButton||component instanceof JLabel||
                    component instanceof JTextField||component instanceof JRadioButton||
                    component instanceof JTextArea||component instanceof JTextPane ||
                    component instanceof JCheckBox||component instanceof JComboBox) {
                component.setFont(font);
            }else if (component instanceof JTable){
                ((JTable)component).getTableHeader().setFont(font);
                ((JTable)component).setFont(font);
            } else{
                setAllFont((Container) component,font);
            }
        }
    }*/

/*
    public static void setPanelOp(Container container) {
        for (int i = 0; i < container.getComponentCount(); i++) {
            Component component = container.getComponent(i);
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                panel.setOpaque(false);
                setPanelOp(panel);
            }
        }
    }
*/

    //???time?????????????????????
    public static int calculateAge(Date dob){
         return calculateAge(dob, new Date());
    }

    //???time?????????????????????
    public static int calculateAge(Date dob,Date time){
        if (null == dob){
            return -1;
        }else{
            Calendar calendarDob = Calendar.getInstance();
            calendarDob.setTime(dob);
            Calendar calendarTime = Calendar.getInstance();
            if (null != time) {
                calendarTime.setTime(time);
            }
            int age = calendarTime.get(Calendar.YEAR) - calendarDob.get(Calendar.YEAR);
            if (calendarTime.get(Calendar.MONTH) < calendarDob.get(Calendar.MONTH)){
                age --;
            }else if (calendarTime.get(Calendar.MONTH) == calendarDob.get(Calendar.MONTH)){
                if (calendarTime.get(Calendar.DAY_OF_MONTH) < calendarDob.get(Calendar.DAY_OF_MONTH)){
                    age -- ;
                }
                //?????????day????????????????????????
            }

            return age;
        }
    }

    public static String calSolnQty(String liqQty ,String infusionSpeed,String drugSpeed,String weight ){  //????????????
        if ("".equalsIgnoreCase(drugSpeed.trim())||"".equalsIgnoreCase(infusionSpeed.trim())||
                "".equalsIgnoreCase(liqQty.trim())||"".equalsIgnoreCase(weight.trim())){
            return "";
        }
//        float f1 = Float.parseFloat(solnQty);   //??????
        float f1 = Float.parseFloat(drugSpeed);   // ??????
        float f2 = Float.parseFloat(infusionSpeed);       //??????
        float f3 = Float.parseFloat(liqQty);      //????????????
        float f4 = Float.parseFloat(weight);      //??????
        float solnQty = (f1*f3 * 60 * f4)/f2;

        return MyUtility.getDecimalFormat(solnQty,3);
    }

    public static String calDrugSpeed(String liqQty ,String solnQty,String infusionSpeed,String weight){ //?????????
        if ("".equalsIgnoreCase(solnQty.trim())||"".equalsIgnoreCase(infusionSpeed.trim())||
                "".equalsIgnoreCase(liqQty.trim())||"".equalsIgnoreCase(weight.trim())){
            return "";
        }
        float f1 = Float.parseFloat(solnQty);   //??????  //g
        float f2 = Float.parseFloat(infusionSpeed);       //??????  ml/h
        float f3 = Float.parseFloat(liqQty);      //????????????  ml
        float f4 = Float.parseFloat(weight);      //?????? , kg
        float drugSpeed = (f1 * f2) / (f3 * 60 * f4); //  ??g/kg.min

        return getDecimalFormat(drugSpeed,3);
    }

    public static String calInfusionSpeed(String liqQty ,String solnQty,String drugSpeed,String weight){ //?????????
        if ("".equalsIgnoreCase(solnQty.trim())||"".equalsIgnoreCase(drugSpeed.trim())||
                "".equalsIgnoreCase(liqQty.trim())||"".equalsIgnoreCase(weight.trim())){
            return "";
        }
        float f1 = Float.parseFloat(solnQty);   //??????
        float f2 = Float.parseFloat(drugSpeed);       //??????
        float f3 = Float.parseFloat(liqQty);      //????????????
        float f4 =  Float.parseFloat(weight);     //??????
        float infusionSpeed = (f2 * f3 * 60 * f4)/ f1;

        return MyUtility.getDecimalFormat(infusionSpeed,0);
    }

    public static String calLiqQty(String solnQty,String infusionSpeed,String drugSpeed ,String weight){ //???????????????
        if ("".equalsIgnoreCase(solnQty.trim())||"".equalsIgnoreCase(infusionSpeed.trim())||
                "".equalsIgnoreCase(drugSpeed.trim())||"".equalsIgnoreCase(weight.trim())){
            return "";
        }
        float f1 = Float.parseFloat(solnQty);   //??????
        float f2 = Float.parseFloat(infusionSpeed);       //??????
        float f3 = Float.parseFloat(drugSpeed);      //??????
        float f4 = Float.parseFloat(weight);      //??????
        float liqQty = (f1 * f2) / (f3 * 60 * f4);

        return MyUtility.getDecimalFormat(liqQty,0);
    }


    private static Map<String, ImageIcon> cacheIcon = new ConcurrentHashMap<String, ImageIcon>();

    public static ImageIcon createImageIcon(String filename) {
        ImageIcon img;
        if (cacheIcon != null) {
            if ((img = cacheIcon.get(filename)) != null) {
                return img;
            }
        }


        URLClassLoader urlLoader =
                (URLClassLoader) MyUtility.class.getClassLoader();

        URL url = urlLoader.findResource("com/zc/icu/ui/images/" + filename);
        if (null == url) {
            logger.info("ERROR icon NOT found  " + filename);
            return new ImageIcon();

        }
        img = new ImageIcon(url);
        cacheIcon.put(filename, img);

        logger.info("loading ImageIcon ok " + filename);
        return img;
    }

    public static String getDecimalFormat2(final Float value) {
        return getDecimalFormat(value,2);
    }

    public static String getDecimalFormat1(final Float value) {
        return getDecimalFormat(value,1);
    }

    public static String getDecimalFormat0(final Float value) {
        return getDecimalFormat(value,0);
    }

    public static String getDecimalFormat(final Float value){
        if (value == null) {
            return "";
        }
        int floatCount = 0;
        String str = String.valueOf(value);
        if (str.contains(".")){
            String[] splits = str.split("\\.");
            if (splits.length > 1) {
                floatCount = splits[1].length();
                if(floatCount > 3){
                    floatCount = 3;
                }
            }
        }

        return getDecimalFormat(value,floatCount);
    }

    public static String getDecimalFormat(final Float value , int floatCount) {
        if (value == null) {
            return "";
        }
        String str = String.valueOf(value);
        StringBuffer str_format = new StringBuffer("####");
        if (floatCount>0){
            str_format.append(".");
        }
        for (int i = 1;i<=floatCount;i++){
            str_format.append("#");
        }

        DecimalFormat decimalFormat = new DecimalFormat(str_format.toString());
        final BigDecimal bd = new BigDecimal(str).setScale(floatCount, BigDecimal.ROUND_HALF_UP);
        str = decimalFormat.format(bd.doubleValue());

        return str;
    }

    public static String getDecimalFormatNotDelZero(final Float value , int floatCount) {
        if (value == null) {
            return "";
        }
        String str = String.valueOf(value);
        StringBuffer str_format = new StringBuffer("####");
        if (floatCount>0){
            str_format.append(".");
        }
        StringBuffer zeroFormat = new StringBuffer(".");
        for (int i = 1;i<=floatCount;i++){
            str_format.append("#");
            zeroFormat.append("0");
        }

        DecimalFormat decimalFormat = new DecimalFormat(str_format.toString());
        str = decimalFormat.format(value);
        if (!str.contains(".") && floatCount > 0) {
            str += zeroFormat.toString();
        }
        return str;
    }

    public static String getIntString(final Float value){
        if (value == null) {
            return "";
        }
        String str = value.toString();
        final BigDecimal bd = new BigDecimal(str).setScale(2, BigDecimal.ROUND_HALF_UP);

        str = DECIMAL_FORMAT0.format(bd.doubleValue());

        return str;
    }

    public static Date getClockDate(final Date date, final int hour) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getHourFirst(Date date) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        cld.set(Calendar.MILLISECOND, 0);
        return cld.getTime();
    }

    public static  Date getStartHourOfDay(Date date , int startHour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        if (calendar.HOUR_OF_DAY < startHour){
            calendar.add(Calendar.DATE,-1);
        }

        calendar.set( Calendar.HOUR_OF_DAY , startHour);
        Date tt = calendar.getTime();
        tt = MyUtility.getHourFirst(tt);

        return tt;

    }

//    public static Number getBedsideValue(Bedside bedside){
//        if( bedside.getFloatCount() == 0){
//            return bedside.getIntVal();
//        }else {
//            return bedside.getfVal();
//        }
//    }

    public static String getShowTime(Date showTime){
        return getShowTime(showTime,false);
    }

    public static String getMyShowTime(Date showTime){
        if (null == showTime){
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        int year_now = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE,1);
        Date tomorrow = calendar.getTime();
        calendar.add(Calendar.DATE,1);
        Date houtian = calendar.getTime();
        calendar.add(Calendar.DATE,-3);
        Date yesterday = calendar.getTime();
        if (showTime.getTime() >= houtian.getTime() || showTime.getTime() < yesterday.getTime()){
            calendar.setTime(showTime);
            int year_show = calendar.get(Calendar.YEAR);
            if (year_now != year_show){
                return MyDateFormat.DATE_FORMAT_YMDHM.format(showTime);
            }
            return MyDateFormat.DATE_FORMAT_MDHM.format(showTime);
        }
        if (showTime.getTime() >= tomorrow.getTime()){
            return "??????" + MyDateFormat.DATE_FORMAT_HM.format(showTime);
        }else if (showTime.getTime() >= today.getTime()){
            return "??????" + MyDateFormat.DATE_FORMAT_HM.format(showTime);
        }else {
            return "??????" + MyDateFormat.DATE_FORMAT_HM.format(showTime);
        }
    }

    public static String getYMDShowTime(Date showTime){
        if (null == showTime){
            return "";
        }
        Calendar calendar = Calendar.getInstance();
        int year_now = calendar.get(Calendar.YEAR);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        Date today = calendar.getTime();
        calendar.add(Calendar.DATE,1);
        Date tomorrow = calendar.getTime();
        calendar.add(Calendar.DATE,1);
        Date houtian = calendar.getTime();
        calendar.add(Calendar.DATE,-3);
        Date yesterday = calendar.getTime();
        if (showTime.getTime() >= houtian.getTime() || showTime.getTime() < yesterday.getTime()){
            calendar.setTime(showTime);
            int year_show = calendar.get(Calendar.YEAR);
            if (year_now != year_show){
                return MyDateFormat.DATE_FORMAT_YMD.format(showTime);
            }
            return MyDateFormat.DATE_FORMAT_MD.format(showTime);
        }
        if (showTime.getTime() >= tomorrow.getTime()){
            return "??????" ;
        }else if (showTime.getTime() >= today.getTime()){
            return "??????" ;
        }else {
            return "??????" ;
        }
    }

    public static String getShowTime(Date showTime,boolean isRecord){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
        //SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm");//????????????
        SimpleDateFormat formatDayHHmm=new SimpleDateFormat("MM-dd HH:mm");//????????????
        SimpleDateFormat oneDayFormat =new SimpleDateFormat("HH:mm");   //?????????
        String strToday;
        String strShowTime;
        Date today;  //?????????0??????

        ParsePosition pos1=new ParsePosition(0);//0????????????
        strToday=dateFormat.format(new Date());
        today= dateFormat.parse(strToday, pos1);

        //?????????????????????0??????????????????
        long time = today.getTime()-showTime.getTime();
        int oneDay = 1000*60*60*24;
        if(time>0 && time<=oneDay){
            strShowTime ="??????"+oneDayFormat.format(showTime);
        }else if(time<=0 && (time+oneDay)>0){
            strShowTime =oneDayFormat.format(showTime);
        }else {
            strShowTime =formatDayHHmm.format(showTime);
        }

        if (!format_y.format(showTime).equalsIgnoreCase(format_y.format(new Date()))){
            // ????????????
            if (isRecord) {
                String line1 = format_y.format(showTime) +"???";
                return "<html>"+line1+"<br/>"+strShowTime+"</html>";
//                return "<html><body>" +
//                        "<p>" + format_y.format(showTime) +"???"+ "</p><br>" +
//                        "<p>" + strShowTime + "</p>" +
//                        "</body></html>";
            }else {
                return format_y.format(showTime)+"-"+strShowTime;
            }
        }else {
            return strShowTime;
        }
    }

    public static boolean compareDate(Date date1,Date date2){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        int yearThis = calendar.get(Calendar.YEAR);
        int monthThis = calendar.get(Calendar.MONTH);
        int dayThis = calendar.get(Calendar.DATE);


        calendar.setTime(date2);
        int yearOther = calendar.get(Calendar.YEAR);
        int monthOther = calendar.get(Calendar.MONTH);
        int dayOther = calendar.get(Calendar.DATE);

        if (yearThis == yearOther && monthThis == monthOther && dayThis == dayOther){
            return true;
        }
        return false;
    }

    public static String getDecimalFormat3(final Float value) {
        if (value == null) {
            return "";
        }
        String str = value.toString();
        final BigDecimal bd = new BigDecimal(str).setScale(3, BigDecimal.ROUND_HALF_UP);

        str = DECIMAL_FORMAT3.format(bd.doubleValue());

        return str;
    }

    public static Date getFormatDate(Date date ,int start_hour){
        return getFormatDate(date,24,start_hour);
    }

    public static Date getFormatDate(Date date , int hours , int start_hour){  // ????????????????????????
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        if (hour<start_hour){   // ????????????
            calendar.add(Calendar.DATE,-1);
        }

        switch (hours){
            case 24:
                calendar.set(Calendar.HOUR_OF_DAY,start_hour);   //???????????????
                break;
            case 8:
                if ( hour>=start_hour && hour<(start_hour+hours)){
                    calendar.set(Calendar.HOUR_OF_DAY,start_hour);   //???????????????
                }else if (hour>=(start_hour+hours) && hour<(start_hour+2*hours)){
                    calendar.set(Calendar.HOUR_OF_DAY,start_hour+hours);   //???????????????
                }else {
                    calendar.set(Calendar.HOUR_OF_DAY,start_hour+2*hours);   //???????????????
                }
                break;
            case 12:
                if ( hour>=start_hour && hour<(start_hour+hours)){
                    calendar.set(Calendar.HOUR_OF_DAY,start_hour);   //???????????????
                }else {
                    calendar.set(Calendar.HOUR_OF_DAY,start_hour+hours);   //???????????????
                }
                break;
            default:
                logger.info("????????????");
                break;
        }


        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.SECOND,0);

        return calendar.getTime();
    }

    /*public static void setTableColWidth(JTable JT, int[] width) {
        TableColumnModel TC = JT.getColumnModel();
        for (int i = 0; i < width.length; i++) {
            if (width[i] > -1) {
                TC.getColumn(i).setMinWidth(width[i]);
                TC.getColumn(i).setMaxWidth(width[i]);
                TC.getColumn(i).setPreferredWidth(width[i]);
            }
        }
    }*/

    /*public static MyG2DInfo saveG2DInfo(Graphics2D g2D){
        MyG2DInfo  g2DInfo =  new MyG2DInfo();

        g2DInfo.color = g2D.getColor();
        g2DInfo.affineTransform=g2D.getTransform();
        g2DInfo.font=g2D.getFont();
        g2DInfo.hints= g2D.getRenderingHints();
        g2DInfo.stroke=g2D.getStroke();

        return  g2DInfo;
    }*/

    /*public static void restoreG2DInfo(Graphics2D g2D ,MyG2DInfo g2DInfo){
        if(null == g2DInfo){
            return;
        }

        g2D.setColor(g2DInfo.color);
        g2D.setFont(g2DInfo.font);
        g2D.setRenderingHints(g2DInfo.hints);
        g2D.setStroke(g2DInfo.stroke);
        g2D.setTransform(g2DInfo.affineTransform);

    }*/


    public static void drawLabels(JPanel panel, Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String lbValue = label.getText();
                g2.setFont(label.getFont());
                int x = label.getX() ;
                int y = label.getY()+label.getHeight();
                g2.drawString(lbValue,x, y);
            }
        }
    }

    public static void drawLabelsRealPosition(JPanel panel, Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String lbValue = label.getText();
                g2.setFont(label.getFont());
                int x = label.getX() ;
                int y = label.getY()+(label.getHeight() + g2.getFontMetrics().getAscent())/2;
                g2.drawString(lbValue,x, y);
            }
        }
    }

    static int checkBoxWidth = 14;
    public static void drawCheckBox(JPanel panel, Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JCheckBox){
                JCheckBox checkBox = (JCheckBox)component;
                String lbValue = checkBox.getText();

                int x = checkBox.getX();
                int y = checkBox.getY()+checkBox.getHeight()-12;
                g2.translate( x, y);
                g2.drawRect( 0 , 0 , checkBoxWidth , checkBoxWidth);
                g2.drawString( lbValue , checkBoxWidth+5 , checkBoxWidth );
                g2.translate( -x, -y);

            }
        }
    }

    public static void drawCheckBoxRealPosition(JPanel panel, Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JCheckBox){
                JCheckBox checkBox = (JCheckBox)component;
                g2.setFont(checkBox.getFont());
                String lbValue = checkBox.getText();
                int x = checkBox.getX();
                int y = checkBox.getY() ;
                int y_down = (checkBox.getHeight() + g2.getFontMetrics().getAscent())/2;
                g2.translate(x, y);
                g2.drawRect( 0 , (checkBox.getHeight() - checkBoxWidth)/2 , checkBoxWidth , checkBoxWidth);
                g2.drawString(lbValue, checkBoxWidth + 5, y_down);
                g2.translate(-x, -y);
            }
        }
    }

    public static void drawLabelsByG2(JPanel panel, Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JLabel) {
                JLabel label = (JLabel) component;
                String lbValue = label.getText();
                //g2.setFont(label.getFont());
                int x = label.getX() ;
                int y = label.getY()+label.getHeight();
                g2.drawString(lbValue,x, y);
            }
        }
    }

    public static void drawAgeTextFieldData(JTextField ageTextField, Graphics2D g2) {
        g2.setRenderingHints(renderingHints);
        if ("".equalsIgnoreCase(ageTextField.getText())){
            return;
        }
        g2.setFont(ageTextField.getFont());
        String ageStr = ageTextField.getText();
        if (!ageStr.contains("/")) {
            if (JTextField.CENTER == ageTextField.getHorizontalAlignment()) {
                int value_w = g2.getFontMetrics().stringWidth(ageStr);
                g2.drawString(ageTextField.getText(), ageTextField.getX() + (ageTextField.getWidth() - value_w)/2,
                        ageTextField.getY() + ageTextField.getHeight());
            }else {
                g2.drawString(ageTextField.getText(), ageTextField.getX(), ageTextField.getY() + ageTextField.getHeight());
            }
        } else {
            int indexLeft = ageStr.indexOf("(");
            int indexRight = ageStr.indexOf(")");
            int indexGap = ageStr.indexOf("/");
            String duLi = ageStr.substring(0, indexLeft);
            String fenZi = ageStr.substring(indexLeft+1, indexGap);
            String fenMu = ageStr.substring(indexGap+1, indexRight);
            FontMetrics fm = g2.getFontMetrics();
            int gapY = (ageTextField.getY() + ageTextField.getHeight() - fm.getAscent()/2);
            int gapX = ageTextField.getX() + fm.stringWidth(duLi) + 2;
            g2.drawString(duLi, ageTextField.getX(), ageTextField.getY() + ageTextField.getHeight());

            Font oldFont = g2.getFont();
            Font fenFont = oldFont.deriveFont(new Float(oldFont.getSize() - 2));
            g2.setFont(fenFont);
            fm = g2.getFontMetrics();
            int gapWidth = fm.stringWidth(fenMu) + 4;
            g2.setRenderingHints(new HashMap<RenderingHints.Key, Object>());
            g2.drawLine(gapX, gapY, gapX + gapWidth, gapY);

            g2.setRenderingHints(renderingHints);
            g2.drawString(fenZi, gapX + (gapWidth-fm.stringWidth(fenZi))/2 , gapY - 2);
            g2.drawString(fenMu, gapX + (gapWidth-fm.stringWidth(fenMu))/2,  gapY + fm.getAscent());

            String unit = ageStr.substring(indexRight+1);
            g2.setFont(oldFont);
            g2.drawString(unit, gapX + gapWidth + 2, ageTextField.getY() + ageTextField.getHeight());
        }
    }

    public static void drawTextFieldData(JPanel panel, JTextField noDraw, Graphics2D g2){
        g2.setRenderingHints(renderingHints);
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField && component != noDraw) {
                JTextField textField = (JTextField) component;
                if ("".equalsIgnoreCase(textField.getText())){
                    continue;
                }
                g2.setFont(textField.getFont());
                if (JTextField.RIGHT == textField.getHorizontalAlignment()) {
                    //????????????
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + textField.getWidth() - value_w, textField.getY() + textField.getHeight());
                }else if (JTextField.CENTER == textField.getHorizontalAlignment()) {
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + (textField.getWidth() - value_w)/2, textField.getY() + textField.getHeight());
                }else {
                    g2.drawString(textField.getText(), textField.getX(), textField.getY() + textField.getHeight());
                }
            }
        }
    }

    public static void drawTextFieldDataByG2(JPanel panel, JTextField noDraw, Graphics2D g2){
        g2.setRenderingHints(renderingHints);
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField && component != noDraw) {
                JTextField textField = (JTextField) component;
                if ("".equalsIgnoreCase(textField.getText())){
                    continue;
                }
                //g2.setFont(textField.getFont());
                if (JTextField.RIGHT == textField.getHorizontalAlignment()) {
                    //????????????
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + textField.getWidth() - value_w, textField.getY() + textField.getHeight());
                }else if (JTextField.CENTER == textField.getHorizontalAlignment()) {
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + (textField.getWidth() - value_w)/2, textField.getY() + textField.getHeight());
                }else {
                    g2.drawString(textField.getText(), textField.getX(), textField.getY() + textField.getHeight());
                }
            }
        }
    }

    public static void drawTextFieldData(JPanel panel, Graphics2D g2){
        g2.setRenderingHints(renderingHints);
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if ("".equalsIgnoreCase(textField.getText())){
                    continue;
                }
                g2.setFont(textField.getFont());
                if (JTextField.RIGHT == textField.getHorizontalAlignment()) {
                    //????????????
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + textField.getWidth() - value_w, textField.getY() + textField.getHeight());
                }else if (JTextField.CENTER == textField.getHorizontalAlignment()) {
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + (textField.getWidth() - value_w)/2, textField.getY() + textField.getHeight());
                }else {
                    g2.drawString(textField.getText(), textField.getX(), textField.getY() + textField.getHeight());
                }
            }
        }
    }

    public static void drawTextFieldDataByG2(JPanel panel, Graphics2D g2){
        g2.setRenderingHints(renderingHints);
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                if ("".equalsIgnoreCase(textField.getText())){
                    continue;
                }
                //g2.setFont(textField.getFont());
                if (JTextField.RIGHT == textField.getHorizontalAlignment()){
                    //????????????
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + textField.getWidth() - value_w, textField.getY() + textField.getHeight() - 3);
                } else if (JTextField.CENTER == textField.getHorizontalAlignment()) {
                    //????????????
                    int value_w = g2.getFontMetrics().stringWidth(textField.getText());
                    g2.drawString(textField.getText(), textField.getX() + (textField.getWidth() - value_w)/2, textField.getY() + textField.getHeight() - 3);
                } else {
                    g2.drawString(textField.getText(), textField.getX(), textField.getY() + textField.getHeight() - 3);
                }
            }
        }
    }

    public static void drawTextFields(JPanel panel ,Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                g2.drawLine(textField.getX(), textField.getY() + textField.getHeight() + 4,
                        textField.getX() + textField.getWidth(), textField.getY() + textField.getHeight() + 4);
            }
        }
    }

    public static void drawTextFieldsRealPosition(JPanel panel ,Graphics2D g2){
        for (Component component : panel.getComponents()){
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                g2.drawLine(textField.getX(), textField.getY() + textField.getHeight() + 1,
                        textField.getX() + textField.getWidth(), textField.getY() + textField.getHeight() + 1);
            }
        }
    }


    public static List<String> calStringLines(String src ,final int FIRSTW, final int MAXW , Graphics2D g2d){
        ArrayList<String> ret = new ArrayList<>();
        int width = FIRSTW;
        int account_w = 0 ;
        StringBuffer stringBuffer = null;
        FontMetrics fontMetrics =  g2d.getFontMetrics();
        for(int index = 0 ; index < src.length() ; index++){
            String one = src.substring(index,index+1);
            account_w +=  fontMetrics.stringWidth( one);  // todo
            if( account_w >= width ||  one.equalsIgnoreCase("\n")){
                if( null == stringBuffer){
                    stringBuffer = new StringBuffer();
                }
                ret.add( stringBuffer.toString());
                stringBuffer = null;
                account_w = fontMetrics.stringWidth( one);
                width = MAXW;
            }
            if( null == stringBuffer){
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(one);
        }
        if (null != stringBuffer) {
            ret.add(stringBuffer.toString());
        }
        return ret;
    }

    public static List<String> calStringLines(String src ,final int width, Font font){
        ArrayList<String> ret = new ArrayList<>();
        int account_w = 0 ;
        StringBuffer stringBuffer = null;
        FontMetrics fontMetrics = new JLabel().getFontMetrics(font);
        for(int index = 0 ; index < src.length() ; index++){
            String one = src.substring(index,index+1);
            account_w +=  fontMetrics.stringWidth( one);  // todo
            if( account_w >= width ||  one.equalsIgnoreCase("\n")){
                if( null == stringBuffer){
                    stringBuffer = new StringBuffer();
                }
                ret.add( stringBuffer.toString());
                stringBuffer = null;
                account_w = fontMetrics.stringWidth( one);
            }
            if( null == stringBuffer){
                stringBuffer = new StringBuffer();
            }
            stringBuffer.append(one);
        }
        if (null != stringBuffer) {
            ret.add(stringBuffer.toString());
        }
        return ret;
    }

//    public static boolean hasOR(String status){
//        switch (status){
//            case Constants.OR_STATUS_FLAG_APPLIED:
//            case Constants.OR_STATUS_FLAG_CHECKED:
//            case Constants.OR_STATUS_FLAG_UNKNOWN:
//            case Constants.OR_STATUS_FLAG_SCHEDULED:
//                return false;
//            default:
//                return true;
//        }
//    }

    public static String getAge(Date dob,Date inRoomTime) {
        if (null == dob) {
            return "";
        }
        Calendar cal = Calendar.getInstance();
        if (null != inRoomTime){
            cal.setTime(inRoomTime);
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        int daysOfMonth = cal.getActualMaximum(Calendar.DATE);
        cal.setTime(dob);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age_year = yearNow - yearBirth;
        int age_month = monthNow - monthBirth;
        int age_day = dayOfMonthNow - dayOfMonthBirth;

        if (age_day < 0){
            age_day += daysOfMonth;
            age_month -- ;
        }
        if (age_month < 0){
            age_month += 12;
            age_year -- ;
        }

        if (age_year > 1){
            return age_year + "???";
        }else if (age_year == 1){
            if (age_month == 0){
                return age_year + "???";
            }else{
//                int greatestCommonDivisor = greatestCommonDivisor(12,age_month);
                return age_year +"(" + age_month +"/" + 12+")" + "???";
            }
        }else if (age_month > 0){
            if (age_day == 0){
                return age_month + "???";
            }else{
//                int greatestCommonDivisor = greatestCommonDivisor(daysOfMonth,age_day);
                int days = (int)((inRoomTime.getTime() - dob.getTime()) / (Constants.ONE_DAY_LONG));
                if (((inRoomTime.getTime() - dob.getTime()) % (Constants.ONE_DAY_LONG)) != 0){
                    days ++;
                }
                return days + "???";
            }
        }else {
            return age_day + "???";
        }
    }

    //??????????????????
    private static int greatestCommonDivisor(int a,int b){
        int min = Math.min(a,b);
        int greatestCommonDivisor = 1;
        for (int i = 2;i<=min;i++){
            if (a % i == 0 && b % i == 0){
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }

    //????????????
    public static int getIntAge(Date dob){
        return getIntAge(dob,new Date());
    }

    //????????????
    public static int getIntAge(Date dob,Date inRoomTime){
        if (null == dob) {
            return 0;
        }
        Calendar cal = Calendar.getInstance();
        if (null != inRoomTime){
            cal.setTime(inRoomTime);
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(dob);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age_year = yearNow - yearBirth;
        int age_month = monthNow - monthBirth;
        int age_day = dayOfMonthNow - dayOfMonthBirth;
        if (age_day < 0){
            age_month -- ;
        }
        if (age_month < 0){
            age_year -- ;
        }
        return age_year;
    }

    //??????ButtonGroup????????????????????????
    public static String buttonGroupSelectText(ButtonGroup bg) {
        Enumeration<AbstractButton> buttons = bg.getElements();
        while (buttons.hasMoreElements()){
            AbstractButton btn = buttons.nextElement();
            if(btn.isSelected()){
                String text = btn.getText();
                return text;
            }
        }
        return null;
    }

    //??????text??????ButtonGroup??????????????????
    public static void buttonGroupSetText(ButtonGroup bg, String text) {
        if (null == text) {
            return;
        }
        Enumeration<AbstractButton> buttons = bg.getElements();
        while (buttons.hasMoreElements()){
            AbstractButton btn = buttons.nextElement();
            if(btn.getText().equals(text)){
                btn.setSelected(true);
                return;
            }
        }
    }

    public static Date getYearFormatDate(int year){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE,1);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);
        calendar.set(Calendar.MONTH,0);

        calendar.set(Calendar.YEAR, year);

        return calendar.getTime();
    }

/*
    public static void setTableStyle(JTable table){
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        table.setFont(MyFont.TABLE_DATA_FONT);
        table.setRowHeight(40);
        table.getTableHeader().setFont(MyFont.MY_FONT_PLAIN_17);
    }
*/

    // ??????????????????
    public static boolean isWholeHour(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int minutes = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        int millisecond = calendar.get(Calendar.MILLISECOND);
        if (0 == minutes && 0 == second && 0 == millisecond){
            return true;
        }
        return false;
    }

    // ???????????????
    public static boolean isToday(Date time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_YEAR);

        calendar.setTimeInMillis(System.currentTimeMillis());
        int y = calendar.get(Calendar.YEAR);
        int m = calendar.get(Calendar.MONTH);
        int d = calendar.get(Calendar.DAY_OF_YEAR);

        if( y ==year && m==month && day==d){
            return true;
        }
        return false;
    }

    // ??????time ????????? startTime ??? endTime ?????????
    public static boolean isInZone(Date time,Date startTime,Date endTime){
        if (time.getTime() >= startTime.getTime() && time.getTime() < endTime.getTime()){
            return true;
        }
        return false;
    }

    //???????????????
    public static Date getCurrentDate(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND,0);

        return calendar.getTime();
    }


   /* public static void setBackgroundColor(Container container) {
        if (container instanceof JPanel) {
            container.setBackground(UITheme.colorInterface.getPanelBgColor());
        }

        for(int i = 0; i < container.getComponentCount(); ++i) {
            Component component = container.getComponent(i);
            if (component instanceof JPanel) {
                component.setBackground(UITheme.colorInterface.getPanelBgColor());
            }

            if (component instanceof Container) {
                setBackgroundColor((Container)component);
            }
        }

    }*/
}
