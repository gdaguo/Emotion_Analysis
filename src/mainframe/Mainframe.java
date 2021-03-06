package mainframe;

import java.sql.Connection;
import java.util.Timer;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import sql.connect_sql;
import sql.hasTable;

import Auto_analyse.Timerclass;

import frameActionPerformed.Mainframe_Renew;
import frameActionPerformed.get_Action;

public class Mainframe extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame4
     */
	private static final long serialVersionUID = 7790250517552433343L;
	public static int flag=-1;              //标记需要从哪个网站下抓取
	public static int Gettype_flag=0;       //标记抓取方式，
	public static String nametemp=null;     //用于记录从数据库读出的收藏人姓名
	public static DefaultListModel<String> listModel1;
	public static DefaultListModel<String> listModel2;
	public static DefaultListModel<String> listModel3;
	public static DefaultListModel<String> listModel4;
	public static String primary="";
	public static int listflag=-1;    //记录最后的点击选中了哪个列表
	public static int hasData=0;
	public static int analysetype=0;
	public static int autobuttonflag=0;
	Timer timer;
    public Mainframe() {
        initComponents();
        Mainframe_Renew.newshow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        namelabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        select = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_collect = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_tieba = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        list_weibo = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        list_renren = new javax.swing.JList();
        get = new javax.swing.JButton();
        add = new javax.swing.JButton();
        renew = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        auto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("网络舆情分析主窗口");
        setResizable(false);               //设置窗口大小不变

        namelabel.setText("目标：");

        name.setText(primary);

        select.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "","百度贴吧", "新浪微博", "人人网" }));
        select.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectItemStateChanged(evt);
            }
        });

        list_collect.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "姓名", "状态值1", "状态值2", "状态值3"
                }
            ));
            jScrollPane1.setViewportView(list_collect);

        jLabel2.setText("收藏人列表");

        jLabel3.setText("百度贴吧");

        jLabel4.setText("新浪微博");

        jLabel5.setText("人人网");

        list_tieba.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(list_tieba);
       

        list_weibo.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(list_weibo);

        list_renren.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(list_renren);

        get.setText("抓     取");
        get.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                getMouseClicked(evt);
            }
        });

        add.setText("添加收藏");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        renew.setText("更新列表");
        renew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                renewMouseClicked(evt);
            }
        });

        auto.setText("自 动 模 式");
        auto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                autoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(namelabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(get))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(jScrollPane4))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(65, 65, 65)
                                    .addComponent(renew)
                                    .addGap(89, 89, 89)
                                    .addComponent(add))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jLabel3)
                                    .addGap(90, 90, 90)
                                    .addComponent(jLabel4)
                                    .addGap(103, 103, 103)
                                    .addComponent(jLabel5)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(auto)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(namelabel)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(select, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(get))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(48, 48, 48))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(renew)
                            .addComponent(add)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(auto)))
                .addGap(10, 10, 10))
        );
        try { 
        	Connection dbConn=connect_sql.Connect();
			int Has=hasTable.hastable(dbConn,"Person_State");
			if(Has==1)
				hasData=1;
		} catch (Exception e) {
			e.printStackTrace();
		}  
        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void autoMouseClicked(java.awt.event.MouseEvent evt) {   //更新按钮执行动作                                
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	if(autobuttonflag==0){
            		int n = JOptionPane.showConfirmDialog(null, "是否启动自动监控模式", "提示",JOptionPane.YES_NO_OPTION);
                	if(n==0){   //选择“是”
                		if(hasData==1){    //如果存在"person_state表"
                			int period=Integer.parseInt(JOptionPane.showInputDialog("设定分析时间间隔        单位：分钟"));
                    	    timer = new Timer();
                   	        timer.schedule(new Timerclass.MyTask(), 0, period*60*1000);
                   	        autobuttonflag=1;
                   	        auto.setText("停          止");
                		}
                		else {
                			JOptionPane.showMessageDialog(null,"收藏人列表为空，请添加目标信息","提示",JOptionPane.ERROR_MESSAGE);
    					}
                	}
            	}
            	else if(autobuttonflag==1){
            		int n = JOptionPane.showConfirmDialog(null, "是否停止自动监控模式", "提示",JOptionPane.YES_NO_OPTION);
            		if(n==0){
            			timer.cancel();        //线程停止
            		    autobuttonflag=0;
            		    auto.setText("自 动 模 式");
            		}
            	}
            }
        });
    }    

    private void selectItemStateChanged(java.awt.event.ItemEvent evt) {                                        
    	if(select.getSelectedIndex()==1)
    		flag=1;
    	else if(select.getSelectedIndex()==2)
    		flag=2;
    	else if(select.getSelectedIndex()==3)
    		flag=3;
    } 
    
    private void addActionPerformed(java.awt.event.ActionEvent evt) {    //添加按钮执行动作                                
    	 java.awt.EventQueue.invokeLater(new Runnable() {
             public void run() {
                 new Addinfo_frame().setVisible(true);
             }
         });
    }                                   
    
    private void getMouseClicked(java.awt.event.MouseEvent evt) {      //抓取按钮执行动作                           
  	  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() { 
            	get_Action.getAction();
            }
        });
   } 
    
    private void renewMouseClicked(java.awt.event.MouseEvent evt) {   //更新按钮执行动作                                
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	Mainframe_Renew.newshow();
            }
        });
    }                    

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JButton add;
    private javax.swing.JButton auto;
    private javax.swing.JButton get;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JTable list_collect;
    public static javax.swing.JList list_renren;
    public static javax.swing.JList list_tieba;
    public static javax.swing.JList list_weibo;
    public static javax.swing.JTextField name;
    private javax.swing.JLabel namelabel;
    private javax.swing.JButton renew;
    private javax.swing.JComboBox select;
    // End of variables declaration                   
}

