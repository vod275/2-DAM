   M S B A M L   `   `   `  ����L  HViewModelAdivinar, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null5clr-namespace:ViewModelAdivinarViewModelAdivinar  5   	   "    ViewModelAdivinar.MainWindow   5   	   W SPresentationCore, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35\ XPresentationFramework, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35e aSystem.Windows.Controls.Ribbon, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089R NWindowsBase, Version=8.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35F 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     5   	   R NSystem.Xaml, Version=8.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml     5   	   @d2http://schemas.microsoft.com/expression/blend/2008     5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006     5   	   1localclr-namespace:ViewModelAdivinar     5   	     � Title$  
MainWindow��5   	   $	��450��6   $	��800��6)   .��5	      � .+�5
   
   �� -   5         ��Name$ imagen��5
      $	��173��6    $��210,39,449,0q�6-   $	��Top=�6C   $��/2-e92dae2b.jpg��6[   �� 5   
   -   5         ��Name$ lbDificultad��5      $ ��Dificultad                ��6&   $
��Left=�5      $��
490,39,0,0q�6-   $	��Top=�6A   $��29��6Y   $��78��6e   �� 5   
   -   5         ��Name$ btFacil��5      $��Facil                 ��6"   $
��Left=�5      $��
432,97,0,0q�6.   $	��Top=�6B   $��24��6Z   $��67��6f    J� RenderTransformOrigin$ 0.5,0.5&�6q   z�5      V� 5      .~�5      �� �� 5      �� 5       �� Angle$ 0.216Q�6&   T� 5      5      5      �� 5   
   -   5        $ 	btDificil��5      $��	Dificil
��6$   $
��Left=�6@   $��528,102,0,0q�6[   $	��Top=�6p   $ 0.5,0.5&�6�   $��20��6�   $��67��6�   5      � 5   
   -   5         �Name$ ProgressBar��5      $
��Left=�6+    � Minimum$ 0Q�6F    � Maximum$	 100Q�6R   $��42��6`   $��104,309,0,0q�6l   $	��Top=�6�   $	��628��6�   	 � Value	 6�   �� *ProgressValue+6�   �� 5   
   -   5        
 ��Name$
 tbRespuesta��5      $
��Left=�6'   $��469,183,0,0q�6B    �� TextWrapping$
 Wrap=�6W   $	��Top=�6l   $	��120��6�   �� 5   
   -   5        $ 	lbAdivina��5      $��Adivina��6#   $
��Left=�65   $��504,217,0,0q�6P   $	��Top=�6e   5      5       