   M S B A M L   `   `   `  ����I  EWPF22_MINI_ITO, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null/clr-namespace:WPF22_MINI_ITOWPF22_MINI_ITO  5   	       WPF22_MINI_ITO.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   .localclr-namespace:WPF22_MINI_ITO     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5   
   ��  �� TabStripPlacement$
 Left=�6   $��
41,123,0,0q�6.   .@�5      �� $��DatosIniciales��6   $��
-2,0,-2,-2q�60   .��5      � $��	0,0,0,-22q�6   .+�5      �� -   5         ��Name$ lbNombreProyecto��5      $��Nombre Proyecto��66   $
��Left=�6P   $��	40,40,0,0q�6k   $	��Top=�6~   $��27��6�   $	��129��6�   �� 5      -   5         ��Name$ tbNombreProyecto��5      $
��Left=�68   $��
196,44,0,0q�6S    �� TextWrapping$
 Wrap=�6g   $	��Top=�6{   $	��120��6�   $��18��6�   �� 5      -   5        $ tbPresupuestoInicial��5      $
��Left=�6<   $��196,175,0,0q�6W   $
 Wrap=�6l   $	��Top=�6�   $	��120��6�    J� RenderTransformOrigin$ 0.11,-3.322&�6�   $��18��6�   �� 5      -   5        $ lbIdentificadorProyectos��5      $��Identificador Proyectos��6>   $
��Left=�6`   $��
40,108,0,0q�6{   $	��Top=�6�   �� 5      -   5        $ lbIDProyecto��5      $��Futuro id Proyecto
��62   $
��Left=�6Y   $��209,108,0,0q�6t   $	��Top=�6�   $��31��6�   $	��107��6�   �� 5      -   5        $ lbPresupuestoInicial��5      $��PresupuestoI nicial��6:   $
��Left=�6X   $��
37,171,0,0q�6s   $	��Top=�6�   �� 5      -   5         ��Name$ btSave��5      $
��Save��6-   $
��Left=�6<   $��231,217,0,0q�6W   $	��Top=�6l   $��54��6�   6�   5      5      �� 5      -   5         ��Name$ btEliminarEmpleado��5      $��	Empleados��62   .��5      � $��0,0,0,-2q�6   $	��664��6)   .+�5      &   System.Windows.Controls.DataGrid  -	   5          Name$ 
dgEmpleado��5      	   AutoGenerateColumns$	 False��6a   $��36,0,56,124q�6~   ��63   �� 
 �� Path$
 listaEmpleados�   Columns 5      0  *System.Windows.Controls.DataGridTextColumn  5       ,  &System.Windows.Controls.DataGridColumn   Header$ Nombre��61      Width5  /System.Windows.Controls.DataGridLengthConverter$ * 6A   1  +System.Windows.Controls.DataGridBoundColumn   Binding 6K   �� *NombreEmpleado+  5!      $	 Rol��61   $ * 6?    6I   �� *Rol+  5"      $ Coste por Hora��61   $ * 6J    6T   �� *Coste_por_Hora+5%      �� 5&      -
   5        $ lbDatosEmpleado��5&      $��Datos Empleado��65   $
��Left=�6N   $��
36,202,0,0q�6i   $	��Top=�6}   �� 5'      -   5        $ tbNombre��5'      $
��Left=�60   $��
36,233,0,0q�6K   $
 Wrap=�6_   $�� ��6s   $	��Top=�6{   $	��120��6�   �� 5(      -   5        $ tbRol��5(      $
��Left=�6-   $��184,233,0,0q�6H   $
 Wrap=�6]   $�� ��6q   $	��Top=�6y   $	��120��6�   �� 5)      -   5        $ tbCoste_Por_Hora��5)      $
��Left=�68   $��351,233,0,0q�6S   $
 Wrap=�6h   $�� ��6|   $	��Top=�6�   $	��120��6�   �� 5*      -   5        $ btAgregarEmpleado��5*      $��Agregar��68   $
��Left=�6J   $��
65,277,0,0q�6e   $	��Top=�6y   6�   �� 5+      -   5        $��Eliminar��5+      $
��Left=�60   $��224,277,0,0q�6K   $	��Top=�6`   6x   5.      52      �� 54      $��	Proyectos��6   .��55      � .+�56        -   5        $ dgProyectos��56      $	 False��6a   $��36,0,56,124q�6~   ��64   �� $
 datosInicilaes� 57        58      $ Nombre del Proyecto��61   $ * 6N    6X   �� *NombreProyecto+  59      $ Presupuesto Inicial��61   $ * 6O    6Y   �� *PresupuestoInicial+  5:      $ Coste Total��61   $ * 6G   5=      �� 5>      -   5        $ btEliminarProyecto��5>      $��Eliminar Proyecto��69   $
��Left=�6U   $��
36,203,0,0q�6p   $	��Top=�6�   6�   �� 5?      -   5        $ lbAsignarEmpleado��5?      $��Asignar Empleados��67   $
��Left=�6S   $��
36,242,0,0q�6n   $	��Top=�6�   �� 5@      -   5         ��Name$ cbEmpleados��5@       �� DisplayMemberPath$ NombreEmpleado��5B       �� SelectedValuePath$ Id��5C      $
��Left=�5D      $��289,242,0,0q�5E      $	��Top=�5F      $	��120��5G      ��5A      �� *ListaEmpleados+5G      �� 5H      -   5        $ btAsignarEmpleado��5H      $��Asignar Empleado��68   $
��Left=�6S   $��289,269,0,0q�6n   $	��Top=�6�   $��26��6�   $	��120��6�   6�   5J      5L      5N      �� 5O   
   -   5         ��Name$ Icono��5O      $
��Left=�6   $	��100��6:   $��	10,10,0,0q�6G   $	��Top=�6Z   $	��100��6r   �� 5P   
   $
��Left=�6   $��
276,10,0,0q�6-   $
 Wrap=�6A   $/��)GESTPRO
GESTION DE PROYECTOS CONSULTORIA��6U   $	��Top=�6�   $	��227��6�   $��55��6�   �� 5Q   
   $��10,0,703,326q�6   $(��"/istockphoto-466167557-612x612.jpg��6&   $
��Fill=�6R   5S      5T      