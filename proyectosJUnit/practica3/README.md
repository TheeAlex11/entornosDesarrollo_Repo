# Práctica 3 — Refactoring OO

> EL README.MD HA SIDO GENERADO CON VSCODE COPILOT
> LINK GIT https://github.com/TheeAlex11/entornosDesarrollo_Repo/tree/main/proyectosJUnit/practica3

## Estructura del proyecto

```
practica3/
├── src/
│   ├── main/java/
│   │   ├── TipoConcierto.java       ← Enum HEAVY / ROCK
│   │   ├── TarifaConcierto.java     ← Interface (Strategy)
│   │   ├── TarifaHeavy.java         ← Implementación HEAVY
│   │   ├── TarifaRock.java          ← Implementación ROCK
│   │   ├── Concierto.java           ← Entidad de dominio
│   │   ├── Actuacion.java           ← Entidad de dominio
│   │   ├── GeneradorFactura.java    ← Genera el texto de factura
│   │   ├── LectorDatos.java         ← Lectura de CSVs
│   │   └── Facturador.java          ← main() - orquestador
│   └── test/java/
│       ├── TarifaConciertoTest.java ← Tests unitarios (Tarea A)
│       └── RegresionFacturaTest.java← Test de regresión (Tarea E)
└── recursos/
    ├── conciertos.csv
    └── datos.csv
```

## Compilar y ejecutar

```bash
# Compilar (requiere JDK + JUnit en lib/)
javac -cp lib/junit.jar -d out/main src/main/java/*.java
javac -cp lib/junit.jar:out/main -d out/test src/test/java/*.java

# Ejecutar tests
java -cp lib/junit.jar:lib/hamcrest.jar:out/main:out/test org.junit.runner.JUnitCore TarifaConciertoTest RegresionFacturaTest

# Ejecutar programa
java -cp out/main Facturador recursos/conciertos.csv recursos/datos.csv
```

## Flujo Git recomendado

```bash
git init
git add .
git commit -m "chore: punto de partida (Facturador2B)"

git checkout -b practica3-oo

git add src/test/java/TarifaConciertoTest.java src/test/java/RegresionFacturaTest.java
git commit -m "test: añade unit tests por tipo de concierto"

git add src/main/java/TipoConcierto.java src/main/java/Concierto.java src/main/java/Actuacion.java
git commit -m "refactor: introduce Concierto y Actuacion (modelo básico)"

git add src/main/java/TarifaConcierto.java src/main/java/TarifaHeavy.java src/main/java/TarifaRock.java
git commit -m "refactor: reemplazado condicional con polimorfismo (importe/créditos)"

git add src/main/java/GeneradorFactura.java src/main/java/LectorDatos.java src/main/java/Facturador.java
git commit -m "refactor: extrae GeneradorFactura y mueve lógica de cálculo"

git commit -m "chore: salida verificada y limpieza final" --allow-empty

git checkout main
git merge practica3-oo
git tag practica3-final
git push origin main --tags
```

## Salida esperada (regresión)

```
FACTURA DE ACTUACIONES
Cliente: Ayuntamiento de Badajoz
	Concierto: Tributo Robe
		Asistentes: 2000
	Concierto: Magia Knopller
		Asistentes: 1200
	Concierto: Tributo Robe
		Asistentes: 950
	Concierto: Demonios Rojos
		Asistentes: 1140
BASE IMPONIBLE: 72800.0 euros
IVA (21%): 15288.00 euros
TOTAL FACTURA: 88088.00 euros
Créditos obtenidos: 3608
```
