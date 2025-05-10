# 1. Flujos de trabajo - Inicio de proyecto grupal Git

## Ejercicio 1: Flujo de trabajo básico

El flujo de trabajo seguido en este proyecto es una simplificación del modelo GitFlow:

- La rama principal es `main`, donde se mantienen las versiones estables.
- Se utiliza la rama `develop` para la integración de características completas.
- Cada nueva funcionalidad se trabaja en una rama `feature/nombre-funcionalidad`.
- Los bugs se corrigen en ramas `fix/nombre-bug`.
- Todos los cambios se integran a través de Pull Requests.
- Los merges los revisa cualquier miembro del equipo que no sea quien hizo la funcionalidad.

## Ejercicio 2: Crear y trabajar en una rama `feature-nueva`

```bash
# Crear la rama
git checkout -b feature-nueva

# Realizar cambios en el código (ej. agregar método suma)
git add .
git commit -m "Agregar método suma a Calculadora"

# Subir la rama
git push origin feature-nueva
```

Luego, se abre un Pull Request desde GitHub para revisión por el equipo.

## Ejercicio 3: Manejo de conflictos en fusión de ramas

Pasos seguidos:

1. Al intentar hacer merge a `develop`, Git detecta conflicto en `Calculadora.java`.
2. Git marca el archivo con los cambios conflictivos.
3. Se abre el archivo y se resuelve el conflicto manualmente.
4. Se realiza `git add Calculadora.java` y luego `git commit`.
5. Finalmente, se ejecuta `git push` para actualizar el PR o la rama.

Responsable de resolver el conflicto: Nahuel

---
