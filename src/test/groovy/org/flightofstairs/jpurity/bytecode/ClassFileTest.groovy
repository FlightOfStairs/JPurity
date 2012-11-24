package org.flightofstairs.jpurity.bytecode

import org.flightofstairs.jpurity.structure.Access
import org.flightofstairs.jpurity.structure.Call
import org.flightofstairs.jpurity.structure.Field
import org.flightofstairs.jpurity.structure.Method
import org.junit.Test

import static org.junit.Assert.assertEquals

class ClassFileTest {
	private final ClassFile aboutFile = ClassFile.forUrl(ClassFileTest.getResource('/About.clazz'))
	private final ClassFile attachDialogFile = ClassFile.forUrl(ClassFileTest.getResource('/AttachDialog.clazz'))

	@Test void testGetFields_about() {
		assertEquals([] as Set, aboutFile.getFields())
	}

	@Test void testGetFields_attachDialog() {
		Set<Field> expectedFields = [
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jLabel1', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'vmTable', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jScrollPane1', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButton', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'packageTextField', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'source', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'warningLabel', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButton', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButton', false),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'tableModel', true),
				new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'descriptors', true)
		]

		assertEquals(expectedFields, attachDialogFile.getFields())
	}

	@Test void testGetMethods_about() {
		Method init = new Method('org/flightofstairs/plaintwitterwidget/About', '<init>', '()V', false, false)
		Method onCreate = new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false)

		assertEquals([init, onCreate] as Set, aboutFile.getMethods());
	}

	@Test void testGetMethods_attachDialog() {
		Set<Method> methods = [
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$0', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;)Ljava/util/List;', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$3', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getSource', '()Lorg/flightofstairs/honours/capture/sources/Source;', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'isAccepted', '()Z', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$1', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false),
				new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$2', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false)
		]

		assertEquals(methods, attachDialogFile.getMethods());
	}

	@Test void testGetCalls_about() {
		Set<Call> calls = [
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false), new Method('org/flightofstairs/plaintwitterwidget/About', 'setContentView', '(I)V', false, false)),
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false), new Method('android/content/SharedPreferences', 'registerOnSharedPreferenceChangeListener', '(Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;)V', false, false)),
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false), new Method('android/app/Activity', 'onCreate', '(Landroid/os/Bundle;)V', false, false)),
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false), new Method('android/preference/PreferenceManager', 'getDefaultSharedPreferences', '(Landroid/content/Context;)Landroid/content/SharedPreferences;', false, false)),
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', 'onCreate', '(Landroid/os/Bundle;)V', false, false), new Method('org/flightofstairs/plaintwitterwidget/About$1', '<init>', '(Lorg/flightofstairs/plaintwitterwidget/About;Landroid/content/SharedPreferences;)V', false, false)),
				new Call(new Method('org/flightofstairs/plaintwitterwidget/About', '<init>', '()V', false, false), new Method('android/app/Activity', '<init>', '()V', false, false))
		]

		assertEquals(calls, aboutFile.getCalls())
	}

	@Test void testGetCalls_attachDialog() {
		Set<Call> calls = [
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', 'setHorizontalGroup', '(Ljavax/swing/GroupLayout$Group;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JButton', 'setText', '(Ljava/lang/String;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'setDefaultCloseOperation', '(I)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$ParallelGroup', 'addGroup', '(Ljavax/swing/GroupLayout$Group;)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'setMinimumSize', '(Ljava/awt/Dimension;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('java/util/List', 'get', '(I)Ljava/lang/Object;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Method('org/flightofstairs/honours/capture/sources/AttachSource', 'getVMList', '()Ljava/util/List;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', 'createParallelGroup', '(Ljavax/swing/GroupLayout$Alignment;Z)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$ParallelGroup', 'addComponent', '(Ljava/awt/Component;Ljavax/swing/GroupLayout$Alignment;III)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Method('java/util/List', 'clear', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$3', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/table/TableColumn', 'setMaxWidth', '(I)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JTextField', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JTable', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', 'setVerticalGroup', '(Ljavax/swing/GroupLayout$Group;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog$2', '<init>', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('java/util/List', 'isEmpty', '()Z', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JLabel', 'setFont', '(Ljava/awt/Font;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JLabel', 'setToolTipText', '(Ljava/lang/String;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addPreferredGap', '(Ljavax/swing/LayoutStyle$ComponentPlacement;)Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$1', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Method('java/util/LinkedList', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'setTitle', '(Ljava/lang/String;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/util/StringTokenizer', 'nextToken', '()Ljava/lang/String;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JButton', 'setPreferredSize', '(Ljava/awt/Dimension;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('java/awt/Dimension', '<init>', '(II)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addContainerGap', '()Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$2', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JButton', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getContentPane', '()Ljava/awt/Container;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/util/LinkedList', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JButton', 'addActionListener', '(Ljava/awt/event/ActionListener;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog$VMTableModel', '<init>', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;Lorg/flightofstairs/honours/app/dialogs/AttachDialog$VMTableModel;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$ParallelGroup', 'addComponent', '(Ljava/awt/Component;)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addComponent', '(Ljava/awt/Component;)Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addComponent', '(Ljava/awt/Component;III)Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/table/TableColumnModel', 'getColumn', '(I)Ljavax/swing/table/TableColumn;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JLabel', 'setVerticalAlignment', '(I)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/lang/String', 'isEmpty', '()Z', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog$1', '<init>', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('java/awt/Font', '<init>', '(Ljava/lang/String;II)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('javax/swing/JTable', 'getSelectedRow', '()I', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/capture/sources/AttachSource', '<init>', '(Lcom/sun/tools/attach/VirtualMachineDescriptor;Ljava/util/List;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'pack', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JTable', 'getColumnModel', '()Ljavax/swing/table/TableColumnModel;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('java/awt/Container', 'setLayout', '(Ljava/awt/LayoutManager;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/util/List', 'add', '(Ljava/lang/Object;)Z', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addGroup', '(Ljavax/swing/GroupLayout$Group;)Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$SequentialGroup', 'addGap', '(III)Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/util/StringTokenizer', 'hasMoreTokens', '()Z', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('javax/swing/JTextField', 'getText', '()Ljava/lang/String;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Method('javax/swing/JDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JScrollPane', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'dispose', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Method('java/util/List', 'addAll', '(Ljava/util/Collection;)Z', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', 'createParallelGroup', '(Ljavax/swing/GroupLayout$Alignment;)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'setVisible', '(Z)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JLabel', 'setText', '(Ljava/lang/String;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/util/StringTokenizer', '<init>', '(Ljava/lang/String;Ljava/lang/String;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'setModal', '(Z)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JScrollPane', 'setViewportView', '(Ljava/awt/Component;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout$ParallelGroup', 'addComponent', '(Ljava/awt/Component;III)Ljavax/swing/GroupLayout$ParallelGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', 'createSequentialGroup', '()Ljavax/swing/GroupLayout$SequentialGroup;', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JTable', 'setModel', '(Ljavax/swing/table/TableModel;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog$3', '<init>', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Method('org/flightofstairs/honours/app/dialogs/AttachDialog$VMTableModel', 'fireTableDataChanged', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JTable', 'setSelectionMode', '(I)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/JLabel', '<init>', '()V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Method('javax/swing/JOptionPane', 'showMessageDialog', '(Ljava/awt/Component;Ljava/lang/Object;Ljava/lang/String;I)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Method('javax/swing/GroupLayout', '<init>', '(Ljava/awt/Container;)V', false, false)),
				new Call(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Method('java/lang/String', 'trim', '()Ljava/lang/String;', false, false))
		]

		assertEquals(calls, attachDialogFile.getCalls())
	}

	@Test void testGetReads_about() {
		assertEquals([] as Set, aboutFile.getReads())
	}

	@Test void testGetReads_attachDialog() {
		Set<Access> reads = [
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('javax/swing/GroupLayout$Alignment', 'TRAILING', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jLabel1', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getSource', '()Lorg/flightofstairs/honours/capture/sources/Source;', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'source', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'isAccepted', '()Z', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'source', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('javax/swing/LayoutStyle$ComponentPlacement', 'RELATED', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jScrollPane1', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'descriptors', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'tableModel', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('javax/swing/GroupLayout$Alignment', 'BASELINE', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'warningLabel', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('javax/swing/GroupLayout$Alignment', 'LEADING', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshVMs', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'tableModel', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'access$0', '(Lorg/flightofstairs/honours/app/dialogs/AttachDialog;)Ljava/util/List;', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'descriptors', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'vmTable', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'descriptors', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'packageTextField', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'getPackages', '()Ljava/util/List;', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'packageTextField', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'vmTable', false))
		]

		assertEquals(reads, attachDialogFile.getReads())
	}

	@Test void testGetWrites_about() {
		assertEquals([] as Set, aboutFile.getWrites())
	}

	@Test void testGetWrites_attachDialog() {
		Set<Access> writes = [
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jLabel1', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'warningLabel', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'tableModel', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButtonActionPerformed', '(Ljava/awt/event/ActionEvent;)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'source', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'attachButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'cancelButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'refreshButton', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'packageTextField', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'vmTable', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', 'initComponents', '()V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'jScrollPane1', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'descriptors', false)),
				new Access(new Method('org/flightofstairs/honours/app/dialogs/AttachDialog', '<init>', '(Ljava/awt/Frame;Z)V', false, false), new Field('org/flightofstairs/honours/app/dialogs/AttachDialog', 'source', false))
		]
		
		assertEquals(writes, attachDialogFile.getWrites())
	}
}