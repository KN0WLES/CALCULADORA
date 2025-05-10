# 3. Deshacer cambios

## Ejercicio 1: git revert

- Comando: `git revert <hash_commit>`

- Crea un nuevo commit que revierte los cambios del commit especificado.
- Ideal para revertir en ramas compartidas porque no reescribe el historial.

```bash
git log
# Identificar el hash del commit a revertir
git revert 3f5d9a2
```

## Ejercicio 2: git reset

```bash
# -soft: mantiene los cambios en staging
git reset --soft <hash>

# -mixed: quita los cambios del staging pero los deja en el working directory
git reset --mixed <hash>

# -hard: borra todo, vuelve el repo al estado exacto del commit
⚠️ git reset --hard <hash>
```

## Ejercicio 3: git reflog

- Permite ver el historial de referencias (incluidos commits "perdidos")

```bash
git reflog
# Restaurar un commit eliminado
git checkout <hash>
```

- Muy útil si se hizo un `reset --hard` por accidente.

---
