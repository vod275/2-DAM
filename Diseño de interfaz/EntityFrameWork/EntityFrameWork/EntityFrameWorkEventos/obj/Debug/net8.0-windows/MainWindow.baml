   M S B A M L   `   `   `  ����Q  MEntityFrameWorkEventos, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null?$clr-namespace:EntityFrameWorkEventosEntityFrameWorkEventos  5   	   '    !EntityFrameWorkEventos.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   6local$clr-namespace:EntityFrameWorkEventos     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� $
��Left=�6   $��	22,19,0,0q�6/   $
��Wrap=�6B   $��Nombre:��6V   $	��Top=�6e   $��28��6}   $��66��6�    �� TextAlignment$ Center=�6�   �� 5   
   -   5         ��Name$ 	txtNombre��5      $
��Left=�6%   $��	93,19,0,0q�6@    �� TextWrapping$
 Wrap=�6S   $	��Top=�6g   $	��237��6   $��28��6�   ��6�   �� *Nombre+ �� UpdateSourceTrigger$ PropertyChanged=� �� ValidatesOnDataErrors$
 True�� �� NotifyOnValidationError$
 True���� 5   
   $
��Left=�6   $��
343,19,0,0q�6/   $
��Wrap=�6C   $��Edad:��6W   $	��Top=�6d   $��28��6|   $��66��6�   $ Center=�6�   �� 5   
   -   5        $ txtEdad��5      $
��Left=�6#   $��
414,19,0,0q�6>   $
 Wrap=�6R   $	��Top=�6f   $��67��6~   $��28��6�   ��6�   �� *Edad+$ PropertyChanged=�$
 True��$
 True���� 5   
   -   5         ��Name$ 
btnAgregar��5      $��Agregar��6%   $
��Left=�67   $��
513,19,0,0q�6R   $	��Top=�6f    J� RenderTransformOrigin$ -0.293,-0.088&�6~   $��28��6�   $��66��6�   6�   &   System.Windows.Controls.DataGrid  5   
   -   5        	  Name$	 DataGridEjemplo��5      $��10,151,10,10q�6,   �� 5   
   -   5        $ btnEliminar��5      $��Borrar��6&   $
��Left=�67   $��
594,19,0,0q�6R   $	��Top=�6f   $ -0.293,-0.088&�6~   $��28��6�   $��66��6�   6�   �� 5   
   -   5        $ btnModificar��5      $��	Modificar��6'   $
��Left=�6;   $��
678,19,0,0q�6V   $	��Top=�6j   $ -0.293,-0.088&�6�   $��28��6�   $��66��6�   6�   �� 5   
   $
��Left=�6   $��	22,81,0,0q�6/   $
��Wrap=�6B   $��Evento Nombre��6V   $	��Top=�6k   $��28��6�   $	��102��6�   $ Center=�6�   �� 5   
   -   5        $ txtNombreEvento��5      $
��Left=�6+   $��
129,81,0,0q�6F   $
 Wrap=�6Z   $	��Top=�6n   $	��201��6�   $��28��6�   �� 5   
   -   5        $ btnAgregarEvento��5      $��Agregar Evento��6+   $
��Left=�6D   $��
353,81,0,0q�6_   $	��Top=�6s   $ -0.293,-0.088&�6�   $��28��6�   $	��117��6�   6�   �� 5   
   -	   5        $ btnMostrarEventos��5      $��Mostrar Eventos��6,   $
��Left=�6F   $��
488,81,0,0q�6a   $	��Top=�6u   $ -0.293,-0.088&�6�   $��28��6�   $	��116��6�   6�   �� 5   
   -
   5        
 ��Name$
 Estado��5      $��Center=�6$   $��	0,127,0,0q�6A   $
��Wrap=�6T   $	��Top=�6h   $��19��6�   $	��780��6�   $ Center=�6�   6�   5      5      