import pandas as pd
import matplotlib.pyplot as plt
import datapane as dp

df = pd.read_csv("DI_U05_A02_PP_E_01.csv")

# 2. Generar gráfico de sectores
df.groupby("Tipo de producto")["Ventas"].sum().plot.pie(title="Ventas por Producto")
grafico1 = dp.Plot(plt.gcf()) 
plt.close() 

# 3. Generar gráfico de líneas
df.groupby("Año")["Ventas"].sum().plot.line("Evolución Temporal")
grafico2 = dp.Plot(plt.gcf())
plt.close()

# 4. Generar gráfico de barras
df.groupby("Región")["Ventas"].sum().plot.bar(title="Ventas por zona")
grafico3 = dp.Plot(plt.gcf())
plt.close()

reporte = dp.Report(
    "# Resumen Ejecutivo",
    grafico1,
    grafico2,
    grafico3
)

reporte.save("informe_ventas.html", open=True)