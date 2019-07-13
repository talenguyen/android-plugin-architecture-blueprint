set -e
stop="./gradlew --stop"
build="./gradlew assembleDebug --stacktrace --rerun-tasks"
install="adb install-multiple /Users/lap00984/Documents/hometest/PluginArchitecture/app/build/outputs/apk/debug/app-debug.apk /Users/lap00984/Documents/hometest/PluginArchitecture/data/build/outputs/apk/debug/data-debug.apk /Users/lap00984/Documents/hometest/PluginArchitecture/detail/build/outputs/apk/debug/detail-debug.apk /Users/lap00984/Documents/hometest/PluginArchitecture/listing/build/outputs/apk/debug/listing-debug.apk /Users/lap00984/Documents/hometest/PluginArchitecture/ui/build/outputs/apk/debug/ui-debug.apk"

$build && $install

echo "Total time: $SECONDS secs"
echo "$SECONDS + " >> build.log

now=$(date)