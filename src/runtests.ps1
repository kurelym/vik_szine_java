param(
    [int] $testNumber = -1 # Alapertelmezett ertek: -1, ami azt jelenti, hogy nincs specifikalt tesztszam
)

# Ha nincs megadva tesztszam, futtassa az osszes tesztet
if ($testNumber -eq -1) {
    # Mappak lekerese es rendezese szam szerint
    $testFolders = Get-ChildItem -Path "tests" -Filter "Teszt*" -Directory | Sort-Object { [int]($_.Name -replace '\D+', '') }
} else {
    # Ellenorizze, hogy a megadott teszt letezik-e
    $testFolderName = "Teszt$testNumber"
    if (-not (Test-Path "tests/$testFolderName")) {
        Write-Host "A megadott teszt ($testFolderName) nem letezik." -ForegroundColor Red
        return
    }

    # Ha letezik, csak ezt a tesztet vegye figyelembe
    $testFolders = @(Get-Item -Path "tests/$testFolderName")
}

# Sikeres tesztek szamlaloja
$successfulTests = 0
$totalTests = 0

Write-Host "==== Tesztek feldolgozasa ====" -ForegroundColor Cyan
Write-Host "" # ures sor

# Minden mappa feldolgozasa
foreach ($folder in $testFolders) {
    $totalTests++
    Write-Host ">> Feldolgozas folyamatban: $($folder.FullName)"
    
    # Fajlok osszeallitasa
    $folderPath = $folder.FullName
    $mapFile = Join-Path $folderPath "map.txt"
    $inputFile = Join-Path $folderPath "input.txt"
    $outputFile = Join-Path $folderPath "output.txt"
    $expectedFile = Join-Path $folderPath "expected.txt"

    # Fajlok ellenorzese es Java parancs futtatasa
    if ((Test-Path $mapFile) -and (Test-Path $inputFile) -and (Test-Path $expectedFile)) {
        Write-Host "Minden szukseges fajl megvan a $($folder.Name) mappaban."

        try {
            java Model.Main $mapFile $inputFile $outputFile
            Write-Host "A Java parancs sikeresen vegrehajtva a $($folder.Name) mappaban."
        } catch {
            Write-Host "Hiba a Java parancs vegrehajtasa kozben a $($folder.Name) mappaban: $_" -ForegroundColor Yellow
            continue
        }

        # Kimenet es elvart eredmeny soronkenti osszehasonlitasa
        $outputLines = Get-Content $outputFile
        $expectedLines = Get-Content $expectedFile
        $mismatchFound = $false

        if ($outputLines.Length -ne $expectedLines.Length) {
            Write-Host "Kulonbozo sorok szama a kimenetben es az elvart eredmenyben a $($folder.Name) mappaban." -ForegroundColor Yellow
            Write-Host "A kimenetnek $($outputLines.Length) sora van, az elvart eredmenynek pedig $($expectedLines.Length)." -ForegroundColor Yellow
            $mismatchFound = $true
        } else {
            for ($i = 0; $i -lt $outputLines.Length; $i++) {
                if ($outputLines[$i] -ne $expectedLines[$i]) {
                    Write-Host "Elteres a $($i + 1). sorban a $($folder.Name) mappaban:" -ForegroundColor Yellow
                    Write-Host "Kimenet:   $($outputLines[$i])" -ForegroundColor Yellow
                    Write-Host "Elvart:    $($expectedLines[$i])" -ForegroundColor Yellow
                    $mismatchFound = $true
                }
            }
        }

        if (-not $mismatchFound) {
            $successfulTests++
            Write-Host "A teszt sikeres volt a $($folder.Name) mappaban." -ForegroundColor Green
        } else {
            Write-Host "A teszt sikertelen volt a $($folder.Name) mappaban." -ForegroundColor Red
        }
    } else {
        Write-Host "Hianyoznak fajlok a $($folder.Name) mappaban." -ForegroundColor Yellow
    }

    Write-Host "" # ures sor a kovetkezo mappa elott
}

# Osszegzes
Write-Host "==== Osszegzes ====" -ForegroundColor Cyan
Write-Host "" # ures sor
Write-Host "A szkript futasa befejezodott." -ForegroundColor White
Write-Host "Osszes teszt: $totalTests" -ForegroundColor White
Write-Host "Sikeres tesztek: $successfulTests" -ForegroundColor Green
