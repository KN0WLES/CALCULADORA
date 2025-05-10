# Proyecto Calculadora

## Nombre del equipo
Team CALCULATOR-3000  
Integrantes: Nahuel, Diego, Winsor

## GitFlow utilizado
Se utilizó una variante del modelo GitFlow con las siguientes características:
- Rama main protegida: contiene la versión estable del proyecto.
- Rama develop: integra funcionalidades listas para producción.
- Ramas feature/nombre: para cada nueva funcionalidad o módulo.
- Ramas fix/nombre: para solucionar errores identificados.
- Pull Requests usados para revisión entre compañeros.

## Bitácora del mini-proyecto
Durante el desarrollo del proyecto se aplicó el flujo GitFlow. Las experiencias fueron:

- ✅ Facilidad para dividir tareas y evitar pisarse el trabajo.
- ⚠️ Problema: Se generó un conflicto entre la rama de Diego y la de Nahuel al modificar el mismo archivo. El conflicto fue generado por Diego al no actualizar su rama antes de hacer merge.
- ✅ El conflicto fue resuelto con una revisión conjunta durante la integración.
- 👍 GitFlow fue útil para organizar el trabajo, aunque al principio hubo confusión sobre cuándo hacer merge a develop.

## Evaluación de buenas y malas prácticas

- Winsor sobre Nahuel:
  - Buenas prácticas: commits descriptivos y frecuentes.
  - Malas prácticas: trabajar directo en develop sin feature branch en una ocasión.

- Nahuel sobre Diego:
  - Buenas prácticas: uso correcto de ramas feature.
  - Malas prácticas: falta de documentación en los commits, algunos fueron genéricos como "arreglos".

- Diego sobre Winsor:
  - Buenas prácticas: uso de alias de Git para revisión rápida.
  - Malas prácticas: olvidó hacer push después de un merge local.

## Alias y hooks utilizados
- Alias creado:
  - git lg = git log --oneline --graph --decorate
- Git Hook:
  - pre-commit: script que previene commits si hay errores de sintaxis en los archivos .java

## Documentación de ejercicios
La carpeta documentacion contiene:

1. flujo_trabajo.md – ejercicios sobre GitFlow y ramas
2. buenas_practicas.md – buenas prácticas y .gitignore
3. deshacer_cambios.md – uso de revert, reset, y reflog
4. trucos_git.md – uso de alias, stash y hooks
