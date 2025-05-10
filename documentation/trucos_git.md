# 4. Truquitos pro en Git (stash, alias, hooks)

## Ejercicio 1: Alias personalizado

Agregar a `~/.gitconfig`:

```ini
[alias]
  lg = log --oneline --graph --decorate --all
  co = checkout
  br = branch
```

Ejemplo de uso:
```bash
git lg
```

## Ejercicio 2: git stash

Guardar cambios sin hacer commit:
```bash
git stash
```

Listar stashes:
```bash
git stash list
```

Aplicar el stash más reciente:
```bash
git stash apply
```

Eliminar stash aplicado:
```bash
git stash drop
```

## Ejercicio 3: Git hook pre-commit

Archivo: `.git/hooks/pre-commit`

```bash
#!/bin/bash

# Verifica si hay errores de sintaxis en archivos .java
for file in $(git diff --cached --name-only | grep ".java$"); do
  javac -Xlint "$file"
  if [ $? -ne 0 ]; then
    echo "Error de compilación en $file. Commit cancelado."
    exit 1
  fi
done
```

Dar permisos:
```bash
chmod +x .git/hooks/pre-commit
```

---
