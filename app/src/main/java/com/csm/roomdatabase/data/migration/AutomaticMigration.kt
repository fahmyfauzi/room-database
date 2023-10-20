package com.csm.roomdatabase.data.migration

import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec

    @RenameColumn(
        tableName = "word_table",
        fromColumnName = "created",
        toColumnName = "createdDate"
    )
    class Migration1To2 : AutoMigrationSpec


