   M S B A M L   `   `   `  ����L  HWPF20_Tab_Control, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:WTF20_Tab_ControlWTF20_Tab_Control  5   	   "    WTF20_Tab_Control.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:WTF20_Tab_Control     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      ��  �� TabStripPlacement$ Bottom=�6   .@�5   
   �� $
��Main��6   .��5      � $��	0,0,0,-22q�6   .+�5      &   System.Windows.Controls.DataGrid  -   5          Name$ 	dgPersona��5      $��402,40,10,143q�6.    J� RenderTransformOrigin$ 
0.37,0.158&�6E      AutoGenerateColumns$ False��6�   ��6h   ��  �� Path$ personas�   Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Nombre��6-   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6=   �� *Nombre+  5      $ 	Apellidos��6-    6@   �� *	Apellidos+  5      $
 Edad��6-    6;   �� *Edad+5      �� 5      -   5        $��lbNombre��5      $��Nombre��6(   $
��Left=�69   $��
158,73,0,0q�6T   $	��Top=�6h   $��26��6�   $��54��6�   $��2��6�   �� 5      -   5        $��tbNombre��5      $
��Left=�6*   $��134,119,0,0q�6E   	 �� TextWrapping$
	 Wrap=�6Z   $	��Top=�6n   $	��120��6�   $��18��6�   $��2��6�   �� 5      -   5        $��lbApellidos��5      $��Apellidos
��6+   $
��Left=�6I   $��174,160,0,0q�6d   $	��Top=�6y   $��42��6�   $��59��6�   $��2��6�   �� 5      -   5        $��tbApellidos��5      $
��Left=�6-   $��134,207,0,0q�6H   $
	 Wrap=�6]   $	��Top=�6q   $	��120��6�   $ 0.11,-3.322&�6�   $��18��6�   $��2��6�   �� 5      -   5        $��lbEdad��5      $
��Edad��6&   $
��Left=�65   $��176,259,0,0q�6P   $	��Top=�6e   $��26��6}   $��36��6�   �� 5      -   5        $��tbEdad1��5      $
��Left=�6)   $��125,306,0,0q�6D   $
	 Wrap=�6Y   $��
��6m   $	��Top=�6   $	��120��6�   $��34��6�   $��2��6�   �� 5      -   5        $��btModificar��5      $��	Modificar��6,   $
��Left=�6@   $��402,365,0,0q�6u   $��64��6�   $	��Top=�6�   �� 5      -	   5        $��
btEliminar��5      $��
Eliminar
��6+   $
��Left=�6H   $	��Top=�6d   $ 0.486,-0.133&�6|   $��18��6�   $��54��6�   $��539,315,0,0q�6�   5"      5#      �� 5$   
   $��Persona��6   .��5%      � .+�5&      �� -
   5        
 ��Name$
 	lbNombre2��5&      $��Nombre��6+   $
��Left=�6<   $��
336,46,0,0q�6W   $	��Top=�6k   $��26��6�   $��54��6�   �� 5'      -   5         ��Name$ 	tbNombre2��5'      $
��Left=�6-   $��
312,92,0,0q�6H   $
	 Wrap=�6\   $	��Top=�6p   $	��120��6�   $��18��6�   �� 5(      -   5        $
 lbApellidos2��5(      $��
Apellidos
��6.   $
��Left=�6G   $��352,133,0,0q�6b   $	��Top=�6w   $��42��6�   $��59��6�   �� 5)      -   5        $ tbApellidos2��5)      $
��Left=�60   $��312,180,0,0q�6K   $
	 Wrap=�6`   $	��Top=�6t   $	��120��6�   $ 0.11,-3.322&�6�   $��18��6�   �� 5*      -   5        $
 lbEdad2��5*      $
��Edad��6)   $
��Left=�68   $��354,232,0,0q�6S   $	��Top=�6h   $��26��6�   $��36��6�   �� 5+      -   5        $ tbEdad2��5+      $
��Left=�6+   $��303,279,0,0q�6F   $
	 Wrap=�6[   $��
��6o   $	��Top=�6|   $	��120��6�   $��34��6�   �� 5,      -   5         ��Name$ btAgragarPersona��5,      $��Agregar Persona��63   $
��Left=�6M   $��340,354,0,0q�6h   $	��Top=�6}   $ -0.116,0.543&�6�   $��20��6�   $��92��6�   6�   5.      50      52      53      