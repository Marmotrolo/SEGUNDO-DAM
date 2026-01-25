import pandas as pd
import datapane as dp
import os
print("Directorio actual:", os.getcwd())
print("CSV existe:", os.path.exists("DI_U05_A02_PP_E_01.csv"))
print("PNG existe:", os.path.exists("DI_U05_A02_07.png"))

fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)

table = dp.Table(df)
data_table = dp.DataTable(df)

report = dp.Report(table, data_table)
report.save(path="DI_U05_A02_03.html", open=True)

datos_diciembre = df[df['Mes'] == 'Diciembre']
unidades_diciembre = datos_diciembre['Unidades'].sum()

datos_noviembre = df[df['Mes'] == 'Noviembre']
unidades_noviembre = datos_noviembre['Unidades'].sum()

unidades = dp.BigNumber(
    heading='Unidades totales en diciembre',
    value=unidades_diciembre,
    change=unidades_diciembre - unidades_noviembre,
    is_upward_change=unidades_diciembre > unidades_noviembre
)

report = dp.Report(unidades)
report.save(path='DI_U05_A02_05.html', open=True)

texto = dp.Text("**Puedes descargar el fichero con los datos del informe.**")

titulo = dp.HTML(
    '<p style="font-size:30px; text-align:center; color:#ffffff; background-color:#4d4d4d;">Informe de ventas</p>'
)

imagen = dp.Media(file='DI_U05_A02_07.png')

fichero = dp.Attachment(file='DI_U05_A02_PP_E_01.csv')

report = dp.Report(
    imagen,
    titulo,
    unidades,
    texto,
    fichero
)

report.save(path='DI_U05_A02_08.html', open=True)