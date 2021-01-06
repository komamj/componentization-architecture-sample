# room
-keep class androidx.room.RoomDataBase { *; }
-keep class androidx.room.Room { *; }
-keep class android.arch.** { *; }
# sqlcipher
-keep,includedescriptorclasses class net.sqlcipher.** { *; }
-keep,includedescriptorclasses interface net.sqlcipher.** { *; }