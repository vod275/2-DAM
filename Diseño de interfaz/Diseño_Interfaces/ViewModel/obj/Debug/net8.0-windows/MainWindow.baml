   M S B A M L   `   `   `  ����D  @ViewModel, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null%clr-namespace:ViewModel	ViewModel  5   	       ViewModel.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   )localclr-namespace:ViewModel     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� -   5         ��Name$ tbNombre��5
      $
��Left=�6$   $��
101,70,0,0q�6?    �� TextWrapping$
 Wrap=�6S   $��
��6g   $	��Top=�6y   $	��120��6�   $��30��6�   �� 5   
   -   5        $ tbEdad��5      $
��Left=�6"   $��101,128,0,0q�6=   $
 Wrap=�6R   $��
��6f   $	��Top=�6x   $	��120��6�   $��28��6�   &   System.Windows.Controls.DataGrid  5   
   -   5          Name$ 	dgPersona��5         AutoGenerateColumns$ False��5      $��284,75,80,197q�5      ��5      ��  �� Path$ lista�   Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Nombre��6%   1  +System.Windows.Controls.DataGridBoundColumn   Binding 65   �� *Nombre+  5      $
 Edad��6%    63   �� *Edad+5      � 5   
   $
��Left=�6   	 � Minimum$	 0Q�61   
 � Maximum$	
 100Q�6=   $��21��6K   $��
139,16,0,0q�6W   $	��Top=�6k   $	��453��6�    � Value 6�   �� *ProgressValue+�� 5   
   -   5        $��Agregar��5      $
��Left=�6#   $��161,217,0,0q�6>   $	��Top=�6S   6k   �� 5   
   -   5         ��Name$ lbDato��5      $��
��6    $
��Left=�65   $��308,326,0,0q�6P   $	��Top=�6e   $��24��6}   $��87��6�   5      5      