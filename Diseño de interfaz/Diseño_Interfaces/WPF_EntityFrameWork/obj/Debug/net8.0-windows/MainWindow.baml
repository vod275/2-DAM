   M S B A M L   `   `   `  ����P  LWPF22_EntityFrameWork, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null9!clr-namespace:WPF_EntityFrameWorkWPF_EntityFrameWork  5   	   $    WPF_EntityFrameWork.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   3local!clr-namespace:WPF_EntityFrameWork     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5
      �� .@�5   
   �� $��Personas��6   .��5      �  � ColumnDefinitions 5      �� 5      $	��81* �6'   �� 5      $	��79* �6'   .+�5      �� -   5         ��Name$ tbNombre��5      $
��Left=�6,   $��
205,52,0,0q�6G    �� TextWrapping$
 Wrap=�6[   $��
��6o   $	��Top=�6�   $	��117��6�   $��17��6�   �� 5      -   5        $ tbEdad��5      $
��Left=�6*   $��
400,52,0,0q�6E   $
 Wrap=�6Y   $��
��6m   $	��Top=�6   $	��117��6�   $��2��6�   $��18��6�   �� 5      -   5         ��Name$ 	btAgregar��5      $��	Agregar
��6,   $
��Left=�6H   $��
170,52,0,0q�6c   $	��Top=�6w   $��18��6�   $��83��6�   $��1��6�   6�   &   System.Windows.Controls.DataGrid  5      -   5          Name$ 	dgPersona��5         AutoGenerateColumns$ False��6.   $��46,124,50,69q�6K   $��2��6a      Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5      ,  &System.Windows.Controls.DataGridColumn   Header$ Id��6-   	   Width5  /System.Windows.Controls.DataGridLengthConverter$	 * 6P   1  +System.Windows.Controls.DataGridBoundColumn
   Binding
 69   �� *Id+6P     5      $ Nombre��6-   $	 * 6X   
 6=   �� *Nombre+6X     5      $
 Edad��6-   $	 * 6T   
 6;   �� *Edad+6T   5      �� 5      -   5        $��
Eliminar
��5      $
��Left=�66   $��380,387,0,0q�6Q   $	��Top=�6f   $��2��6~   $��20��6�   $��48��6�   6�   �� 5      -   5        $��Modificar
��5      $
��Left=�67   $��
99,387,0,0q�6R   $	��Top=�6f   $��1��6~   $��20��6�   $��56��6�   6�   5      5       �� 5$   
   $��Mascotas��6   .��5%      �  5&      �� 5'      $	��81* �6'   �� 5(      $	��79* �6'   .+�5*      �� -   5        $ tbNombreMascota��5*      $
��Left=�63   $��	84,52,0,0q�6N   $
 Wrap=�6a   $��
��6u   $	��Top=�6�   $	��117��6�   $��17��6�   �� 5+      -   5        $ tbTipo��5+      $
��Left=�6*   $��
235,51,0,0q�6E   $
 Wrap=�6Y   $��
��6m   $	��Top=�6   $	��117��6�   $��19��6�   �� 5,      -	   5        $ tbPersonaID��5,      $
��Left=�6/   $��
395,51,0,0q�6J   $
 Wrap=�6^   $��
��6r   $	��Top=�6�   $	��117��6�   $��18��6�   $��2��6�   �� 5-      -
   5        $ btAgregarMascota��5-      $��	Agregar
��63   $
��Left=�6O   $��
170,52,0,0q�6j   $	��Top=�6~   $��18��6�   $��83��6�   $��1��6�   6�     5.      -   5        $ 	dgMascota��5.      $ False��6.   $��46,124,50,69q�6K   $��2��6a    5/        50      $ Id��6-   $	 * 6P   
 69   �� *id+6P     51      $ Nombre��6-   $	 * 6X   
 6=   �� *nombre+6X     52      $
 Tipo��6-   $	 * 6T   
 6;   �� *tipo+6T     53      $ 
Id Persona��6-   $	 * 6_   
 6A   �� *	personaid+6_   55      �� 56      -   5        $��
Eliminar
��56      $
��Left=�66   $��380,387,0,0q�6Q   $	��Top=�6f   $��2��6~   $��20��6�   $��48��6�   6�   �� 57      -   5        $��Modificar
��57      $
��Left=�67   $��
99,387,0,0q�6R   $	��Top=�6f   $��1��6~   $��20��6�   $��56��6�   6�   5:      5;      5>      5@      