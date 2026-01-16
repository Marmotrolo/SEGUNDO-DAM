import pandas as pd
import datapane as dp
import os

# Verificar archivos
print("Directorio actual:", os.getcwd())
print("CSV existe:", os.path.exists("DI_U05_A02_PP_E_01.csv"))
print("Logo existe:", os.path.exists("DI_U05_A02_PP_E_02.jpg"))

# Cargar datos
fichero_csv = "DI_U05_A02_PP_E_01.csv"
df = pd.read_csv(fichero_csv)

# 1. Logotipo de la empresa
logotipo = dp.Media(file='DI_U05_A02_PP_E_02.jpg')

# 2. Título del informe
titulo = dp.HTML(
    '<p style="font-size:36px; text-align:center; color:#ffffff; background-color:#2c3e50; padding:20px; font-weight:bold;">Informe de ventas</p>'
)

# 3. Sección de resumen ejecutivo

# Calcular total de ventas acumuladas
total_ventas_acumuladas = df['Ventas'].sum()

# Calcular año con mayor volumen de ventas
ventas_por_año = df.groupby('Año')['Ventas'].sum()
año_mayor_ventas = ventas_por_año.idxmax()
importe_año_mayor = ventas_por_año.max()

# Crear texto de resumen ejecutivo
texto_resumen = dp.Text("""
### Resumen Ejecutivo

Estos indicadores permiten a la dirección identificar tendencias de crecimiento a largo plazo y 
evaluar el desempeño anual de la organización. Conocer el año de mayor facturación ayuda a analizar 
qué estrategias comerciales fueron más efectivas y replicarlas en períodos futuros.
""")

# BigNumbers para el resumen ejecutivo
bn_total_acumulado = dp.BigNumber(
    heading='Total ventas acumuladas (2017-2021)',
    value=total_ventas_acumuladas 
)

bn_año_mayor = dp.BigNumber(
    heading='Año con mayor volumen de ventas',
    value=año_mayor_ventas,
    is_upward_change=True
)

# 4. Ventas del año 2021 comparadas con 2020
ventas_2021 = df[df['Año'] == 2021]['Ventas'].sum()
ventas_2020 = df[df['Año'] == 2020]['Ventas'].sum()

bn_ventas_2021 = dp.BigNumber(
    heading='Ventas totales año 2021',
    value=ventas_2021,
    change=ventas_2021 - ventas_2020,
    is_upward_change=ventas_2021 > ventas_2020
)

# 5. Tabla interactiva con los datos
table = dp.Table(df)

tabla_interactiva = dp.DataTable(df)

# 6. Texto para descargar datos
texto_descarga = dp.Text("**Puedes descargar el fichero con los datos del informe.**")

# Archivo adjunto
fichero_adjunto = dp.Attachment(file='DI_U05_A02_PP_E_01.csv')

# Crear informe completo
report = dp.Report(
    logotipo,
    titulo,
    texto_resumen,
    bn_total_acumulado,
    bn_año_mayor,
    bn_ventas_2021,
    table,
    tabla_interactiva,
    texto_descarga,
    fichero_adjunto
)

# Guardar informe
report.save(path='informe_ventas_completo.html', open=True)