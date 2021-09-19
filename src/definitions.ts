export interface FileSaverPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
