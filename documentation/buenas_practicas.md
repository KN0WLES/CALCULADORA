# 2. Buenas prácticas en Git

## Ejercicio 1: Cinco buenas prácticas en Git colaborativo

1. Usar nombres descriptivos para ramas:
   - Ej: `feature/login-form` o `fix/null-pointer-calculo`.

2. Commits frecuentes con mensajes claros:
   - ✅ "Agregar validación de inputs vacíos en método dividir"
   - ❌ "cambios"

3. Hacer pull regularmente desde `develop` para evitar conflictos.

4. No trabajar nunca directo sobre `main`.

5. Usar Pull Requests para revisión antes de merge.

## Ejercicio 2: Archivo .gitignore

```gitignore
# Compilados Java
*.class

# Directorios
bin/
out/

# Archivos de sistema
.DS_Store
Thumbs.db

# Archivos de IDE
*.iml
.idea/
.vscode/
```

## Ejercicio 3: Gestión de versiones SemVer

- Se siguen versiones del tipo: `MAJOR.MINOR.PATCH`

  - `1.0.0` Versión inicial estable
  - `1.1.0` Nueva funcionalidad agregada (no rompe compatibilidad)
  - `1.1.1` Corrección de errores menores

- Para etiquetar una versión:
```bash
git tag -a v1.0.0 -m "Versión estable inicial"
git push origin v1.0.0
```

---
