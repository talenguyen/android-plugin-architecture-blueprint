set -e

stop="./gradlew --stop"

build="./gradlew \
app:assembleDebug \
data:assembleDebug \
ui:assembleDebug \
detail:assembleDebug \
--stacktrace"

uninstall="adb uninstall com.example.pluginarchitecture"

install="adb install-multiple \
/Users/lap00984/Documents/hometest/PluginArchitecture/app/build/outputs/apk/debug/app-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/data/build/outputs/apk/debug/data-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/ui/build/outputs/apk/debug/ui-debug.apk \
/Users/lap00984/Documents/hometest/PluginArchitecture/detail/build/outputs/apk/debug/detail-debug.apk"

launch='adb shell am start -a android.intent.action.VIEW -d "example://d/123"'

$build && $uninstall || true && $install && $launch

echo "Total time: $SECONDS secs"

now=$(date)